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

public class ComputeKeyPhrases implements DataProcessor {

	protected String outputFileName;
	
	public ComputeKeyPhrases(String outputFileName){
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
			writer.write("msgId,keyword\n");
			Map<String, List<String>> keywords = TextAnalyticsClientUtil.getKeyPhrasesBulk(inputs);
			for(Map.Entry<String, List<String>> entry : keywords.entrySet()){
				for(final String keyword : entry.getValue()){
					writer.write(entry.getKey());
					writer.write("\t");
					writer.write(keyword);
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
