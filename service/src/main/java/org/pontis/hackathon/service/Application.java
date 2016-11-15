package org.pontis.hackathon.service;

import java.util.List;

import org.hackathon.fetchers.twitter.ISocialGetter;
import org.pontis.hackathon.datamodel.SocialMessage;

public class Application {
	
	private List<ISocialGetter> socialGetters;
	private List<DataProcessor> dataProcessors;
	
	void doProcessing(){
		for(final ISocialGetter socialGetter : socialGetters){
			List<SocialMessage> messages = socialGetter.getNextMessages();
			for(final DataProcessor dataProcessor : dataProcessors){
				dataProcessor.process(messages);
			}
		}
	}
}
