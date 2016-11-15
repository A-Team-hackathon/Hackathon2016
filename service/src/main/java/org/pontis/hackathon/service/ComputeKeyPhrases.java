package org.pontis.hackathon.service;

import java.io.BufferedWriter;
import java.util.List;

import org.pontis.hackathon.datamodel.SocialMessage;
import org.pontis.hackathon.textanalytics.client.TextAnalyticsClientUtil;

public class ComputeKeyPhrases implements DataProcessor {

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
		
	}

}
