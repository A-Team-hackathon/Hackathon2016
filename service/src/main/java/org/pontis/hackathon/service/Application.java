package org.pontis.hackathon.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pontis.hackathon.datamodel.SocialMessage;

public class Application {
	
	private List<DataProcessor> dataProcessors;
	
	public Application(){
		dataProcessors = new ArrayList<>();
		dataProcessors.add(new ComputeKeyPhrases("message_keywords.csv"));
		dataProcessors.add(new SentimentAnalysis("message_sentiment.csv"));
	}
	
	void doProcessing(){
		List<SocialMessage> messages = readSocialMedia("C:\\Users\\YuvalLi\\git\\Hackathon2016\\twitter_fetcher\\twitter.csv");
		for(final DataProcessor dataProcessor : dataProcessors){
			dataProcessor.process(messages);
		}
	}
	
	public List<SocialMessage> readSocialMedia(String inputFileName){
		List<SocialMessage> messages = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
			String header = reader.readLine();
			String line = reader.readLine();
			while(line != null){
				String[] tokens = line.split(",");
				SocialMessage message = new SocialMessage();
				message.setTimeStamp(new Date(Long.parseLong(tokens[0])));
				message.setMessageId(tokens[1]);
				message.setPrevMessageId(tokens[2]);
				message.setFromUser(tokens[3]);
				message.setPrevMessageSender(tokens[4]);
				message.setMessagePopularity(tokens[5] == null ? null : Integer.parseInt(tokens[5]));
				message.setMessageText(tokens[6]);
				messages.add(message);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return messages;
	}
	
	public static void main(String[] args){
		new Application().doProcessing();
	}
}
