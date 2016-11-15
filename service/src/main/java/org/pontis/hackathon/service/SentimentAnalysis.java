package org.pontis.hackathon.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.pontis.hackathon.datamodel.SocialMessage;
import org.pontis.hackathon.textanalytics.client.TextAnalyticsClientUtil;

public class SentimentAnalysis implements DataProcessor {
	
	protected final String outputFileName;
	
	public SentimentAnalysis(final String outputFileName){
		this.outputFileName = outputFileName;
	}
	
	@Override
	public void process(List<SocialMessage> messages) {
		final List<String> inputs = new ArrayList<>();
		for(final SocialMessage message : messages){
			inputs.add(message.getMessageText());
		}
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)));
			writer.write("msgId,sentiment\n");
			Map<String, Double> sentiments = TextAnalyticsClientUtil.getSentimentBulk(inputs);
			for(Map.Entry<String, Double> entry : sentiments.entrySet()){
				writer.write(entry.getKey());
				writer.write("\t");
				writer.write(Double.toString(entry.getValue()));
				writer.write("\n");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
