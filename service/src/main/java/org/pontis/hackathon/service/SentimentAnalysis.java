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

public class SentimentAnalysis implements DataProcessor {
	
	protected final String outputFileName;
	
	protected int BULK = 500;
	
	public SentimentAnalysis(final String outputFileName){
		this.outputFileName = outputFileName;
	}
	
	@Override
	public void process(List<SocialMessage> messages) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)));
			writer.write("msgId\tsentiment\n");
			for(int i = 0 ; i < messages.size() / BULK; i++){
				List<SocialMessage> sub = messages.subList(i * BULK, Math.min(i * BULK + BULK, messages.size()));
				final Map<String, String> inputs = new HashMap<>();
				for(final SocialMessage message : sub){
					inputs.put(message.getMessageId(), message.getMessageText());
				}
				Map<String, Double> sentiments = TextAnalyticsClientUtil.getSentimentBulk(inputs);
				for(Map.Entry<String, Double> entry : sentiments.entrySet()){
					writer.write(entry.getKey());
					writer.write("\t");
					writer.write(Double.toString(entry.getValue()));
					writer.write("\n");
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
