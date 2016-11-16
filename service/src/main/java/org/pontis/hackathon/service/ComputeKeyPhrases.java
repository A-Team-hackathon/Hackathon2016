package org.pontis.hackathon.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.pontis.hackathon.datamodel.SocialMessage;
import org.pontis.hackathon.textanalytics.client.TextAnalyticsClientUtil;

public class ComputeKeyPhrases implements DataProcessor {

	protected static final String FILE_NAME = "message_keywords.csv";
	
	@Override
	public void process(List<SocialMessage> messages) {
		StringBuilder builder = new StringBuilder();
		builder.append("messageId,keyword");
		for(final SocialMessage message : messages){
			final List<String> phrases = TextAnalyticsClientUtil.getKeyPhrases(message.getMessageText());
			for(final String phrase : phrases){
				builder.append(message.getMessageId());
				builder.append(",");
				builder.append(phrase);
				builder.append("\n");
			}
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
