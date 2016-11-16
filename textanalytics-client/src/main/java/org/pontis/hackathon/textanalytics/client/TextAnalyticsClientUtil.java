package org.pontis.hackathon.textanalytics.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pontis.hackathon.ApiException;
import org.pontis.hackathon.textanalytics.client.api.DefaultApi;
import org.pontis.hackathon.textanalytics.client.model.KeyPhraseBatchResultItemV2;
import org.pontis.hackathon.textanalytics.client.model.MultiLanguageBatchInputV2;
import org.pontis.hackathon.textanalytics.client.model.MultiLanguageInputV2;
import org.pontis.hackathon.textanalytics.client.model.SentimentBatchResultItemV2;

public class TextAnalyticsClientUtil {
	
	private final static DefaultApi api = new DefaultApi();
	private final static String ocpApimSubscriptionKey = "6c760ddee6f74b89a71e42bbcdf700ad";
	private final static String subscriptionKey = ocpApimSubscriptionKey;
	
	public static List<String> getKeyPhrases(String input) {
		List<String> result = null;
        try {
			result = api.keyPhrases(subscriptionKey, ocpApimSubscriptionKey, buildInput(input)).getDocuments().get(0).getKeyPhrases();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Map<String, List<String>> getKeyPhrasesBulk(Map<String, String> inputs) {
		Map<String, List<String>> result = new HashMap<>();
        try {
			List<KeyPhraseBatchResultItemV2> apiResponse = api.keyPhrases(subscriptionKey, ocpApimSubscriptionKey, buildInputBulk(inputs)).getDocuments();
			for (KeyPhraseBatchResultItemV2 apiResponseItem : apiResponse) {
				List<String> keyPhrases = apiResponseItem.getKeyPhrases();
				if (keyPhrases != null && !keyPhrases.isEmpty()) {
					result.put(apiResponseItem.getId(), keyPhrases);
				}
			}
			apiResponse.get(0).getKeyPhrases();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static double getSentiment(String input) {
		double result = 0.5;
        try {
			result = api.sentiment(subscriptionKey, ocpApimSubscriptionKey, buildInput(input)).getDocuments().get(0).getScore();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Map<String, Double> getSentimentBulk(Map<String, String> inputs) {
		Map<String, Double> result = new HashMap<>();
		try {
			List<SentimentBatchResultItemV2> apiResponse = api.sentiment(subscriptionKey, ocpApimSubscriptionKey, buildInputBulk(inputs)).getDocuments();
			for (SentimentBatchResultItemV2 apiResponseItem : apiResponse) {
				Double score = apiResponseItem.getScore();
				if (score != null) {
					result.put(apiResponseItem.getId(), score);
				}
			}
			apiResponse.get(0).getScore();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static MultiLanguageBatchInputV2 buildInput(String input) {
		MultiLanguageBatchInputV2 multiLanguageBatchInputV2 = new MultiLanguageBatchInputV2();
        List<MultiLanguageInputV2> documents = new ArrayList<>();
        MultiLanguageInputV2 document = new MultiLanguageInputV2();
        document.setLanguage("en");
        document.setId("goat");
        document.setText(input);
		documents.add(document);
		multiLanguageBatchInputV2.setDocuments(documents);
		return multiLanguageBatchInputV2;
	}
	
	private static MultiLanguageBatchInputV2 buildInputBulk(Map<String, String> inputs) {
		MultiLanguageBatchInputV2 multiLanguageBatchInputV2 = new MultiLanguageBatchInputV2();
        List<MultiLanguageInputV2> documents = new ArrayList<>();
        for (Map.Entry<String, String> input : inputs.entrySet()) {
        	MultiLanguageInputV2 document = new MultiLanguageInputV2();
        	document.setLanguage("en");
        	document.setId(input.getKey());
        	document.setText(input.getValue());
        	documents.add(document);
        }
		multiLanguageBatchInputV2.setDocuments(documents);
		return multiLanguageBatchInputV2;
	}

}
