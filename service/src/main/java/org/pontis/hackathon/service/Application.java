package org.pontis.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.hackathon.fetchers.ISocialGetter;
import org.hackathon.fetchers.twitter.TweetFetcher;
import org.pontis.hackathon.datamodel.SocialMessage;

public class Application {
	
	private List<ISocialGetter> socialGetters;
	private List<DataProcessor> dataProcessors;
	
	public Application(){
		socialGetters = new ArrayList<>();
		dataProcessors = new ArrayList<>();
		socialGetters.add(new TweetFetcher(""));
		dataProcessors.add(new ComputeKeyPhrases());
	}
	
	void doProcessing(){
		for(final ISocialGetter socialGetter : socialGetters){
			List<SocialMessage> messages = readSocialMedia();
			for(final DataProcessor dataProcessor : dataProcessors){
				dataProcessor.process(messages);
			}
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
