package org.pontis.hackathon.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.pontis.hackathon.datamodel.SocialMessage;
import org.pontis.hackathon.luis.client.LUISUtil;
import org.pontis.hackathon.luis.client.LUISUtil.IntentAndEntities;
import org.pontis.hackathon.textanalytics.client.TextAnalyticsClientUtil;

public class IntentAnalysis implements DataProcessor {

	protected String outputFileName;

	public IntentAnalysis(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	@Override
	public void process(List<SocialMessage> messages) {
		BufferedWriter writer;
		try {
			List<Future<FutureBean>> futures = new ArrayList<>();
			ExecutorService threadPool = Executors.newFixedThreadPool(1);
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)));
			writer.write("msgId\tintent\n");
			BufferedWriter writerEntities = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("message_entities.csv")));
			writerEntities.write("msgId\tentity\n");
			for (final SocialMessage sm : messages) {
				futures.add(threadPool.submit(new Callable<FutureBean>() {

					@Override
					public FutureBean call() throws Exception {
						FutureBean fb = new FutureBean();
						boolean success = false;
						int retries=1;
						while (!success) {
							try {
								IntentAndEntities topIntentAndEntities = LUISUtil
										.getTopIntentAndEntities(sm.getMessageText());
								fb.intent = topIntentAndEntities.intent;
								fb.MessageId = sm.getMessageId();
								fb.entities = topIntentAndEntities.entities;
								success = true;
							} catch (Exception e) {
								System.err.println("error #" + retries);
								retries++;
							}
						}
						return fb;
					}

				}));
			}
			int i=1;
			for (final Future<FutureBean> future : futures) {
				FutureBean fb;
				try {
					fb = future.get();
					if (fb.intent != null) {
						String line = fb.MessageId + "\t" + fb.intent + "\n";
						writer.write(line);
						System.out.println(i + ": " + line);
						writer.flush();
						
					}
					
					if (fb.entities != null && fb.entities.size() > 0) {
						for (String entityId : fb.entities) {
							String line = fb.MessageId + "\t" + entityId + "\n";
							writerEntities.write(line);
							System.out.println(i + ": " + line);
							
						}
						writerEntities.flush();
					}
					i++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			//System.out.println("next batch of 20 intent calculation took " + (System.currentTimeMillis() - start));

			writer.close();
			writerEntities.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class FutureBean {
		public String MessageId;
		public String intent;
		public List<String> entities;
	}

}
