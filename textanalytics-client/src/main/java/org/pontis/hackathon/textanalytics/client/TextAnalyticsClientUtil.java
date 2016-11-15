package org.pontis.hackathon.textanalytics.client;

import java.util.ArrayList;
import java.util.List;

import org.pontis.hackathon.ApiException;
import org.pontis.hackathon.textanalytics.client.api.DefaultApi;
import org.pontis.hackathon.textanalytics.client.model.MultiLanguageBatchInputV2;
import org.pontis.hackathon.textanalytics.client.model.MultiLanguageInputV2;

public class TextAnalyticsClientUtil {
	
	private final static DefaultApi api = new DefaultApi();
	private final static String ocpApimSubscriptionKey = "9aa00ea97c5e4753b97e54507f9eb03b";
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
	
	public static double getSentiment(String input) {
		double result = 0.5;
        try {
			result = api.sentiment(subscriptionKey, ocpApimSubscriptionKey, buildInput(input)).getDocuments().get(0).getScore();
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

}
