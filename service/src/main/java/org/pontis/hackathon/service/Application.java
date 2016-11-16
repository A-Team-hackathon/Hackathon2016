package org.pontis.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.hackathon.fetchers.twitter.ISocialGetter;
import org.hackathon.fetchers.twitter.TweetFetcher;
import org.pontis.hackathon.datamodel.SocialMessage;

public class Application {
	
	private List<DataProcessor> dataProcessors;
	
	public Application(){
		dataProcessors = new ArrayList<>();
		dataProcessors.add(new ComputeKeyPhrases("message_keywords.csv"));
		dataProcessors.add(new SentimentAnalysis("message_sentiment.csv"));
	}
	
	void doProcessing(){
		List<SocialMessage> messages = readSocialMedia();
		for(final DataProcessor dataProcessor : dataProcessors){
			dataProcessor.process(messages);
		}
	}
	
	public List<SocialMessage> readSocialMedia(){
		List<SocialMessage> messages = new ArrayList<>();
		return messages;
	}
	
	public static void main(String[] args){
		new Application().doProcessing();
	}
}
