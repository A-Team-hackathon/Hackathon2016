package org.pontis.hackathon.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pontis.hackathon.datamodel.SocialMessage;
import org.pontis.hackathon.textanalytics.client.TextAnalyticsClientUtil;

public class ComputeKeyPhrases implements DataProcessor {

	protected String outputFileName;
	
	protected int BULK = 500;
	
	public ComputeKeyPhrases(String outputFileName){
		this.outputFileName = outputFileName;
	}
	
	@Override
	public void process(List<SocialMessage> messages) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)));
			writer.write("msgId\tkeyword\n");
			for(int i = 0 ; i < messages.size() / BULK; i++){
				List<SocialMessage> sub = messages.subList(i * BULK, Math.min(i * BULK + BULK, messages.size()));
				final Map<String, String> inputs = new HashMap<>();
				for(final SocialMessage message : sub){
					inputs.put(message.getMessageId(), message.getMessageText());
				}
				Map<String, List<String>> keywords = TextAnalyticsClientUtil.getKeyPhrasesBulk(inputs);
				for(Map.Entry<String, List<String>> entry : keywords.entrySet()){
					for(final String keyword : entry.getValue()){
						writer.write(entry.getKey());
						writer.write("\t");
						writer.write(keyword);
						writer.write("\n");
					}
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
