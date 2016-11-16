package org.pontis.hackathon.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.pontis.hackathon.datamodel.SocialMessage;
import org.pontis.hackathon.textanalytics.client.TextAnalyticsClientUtil;

public class SentimentAnalysis implements DataProcessor {
	
	protected final String outputFileName;
	
	public SentimentAnalysis(final String outputFileName){
		this.outputFileName = outputFileName;
	}
	
	@Override
	public void process(List<SocialMessage> messages) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)));
			writer.write("msgId,sentiment\n");
			for(final SocialMessage message : messages){
				double sentiment = TextAnalyticsClientUtil.getSentiment(message.getMessageText());
				writer.write(message.getMessageId());
				writer.write(",");
				writer.write(Double.toString(sentiment));
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
