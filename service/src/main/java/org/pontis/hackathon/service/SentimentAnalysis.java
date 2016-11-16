package org.pontis.hackathon.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.pontis.hackathon.datamodel.SocialMessage;
import org.pontis.hackathon.textanalytics.client.TextAnalyticsClientUtil;

public class SentimentAnalysis implements DataProcessor {
	
	protected final static String FILE_NAME = "sentiment.csv";
	
	@Override
	public void process(List<SocialMessage> messages) {
		StringBuilder builder = new StringBuilder();
		builder.append("messageId,sentiment");
		for(final SocialMessage message : messages){
			double sentiment = TextAnalyticsClientUtil.getSentiment(message.getMessageText());
			builder.append(message.getMessageId());
			builder.append(",");
			builder.append(sentiment);
			builder.append("\n");
		}
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_NAME)));
			writer.write(builder.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
