package org.pontis.hackathon.textanalytics.client;

import java.util.ArrayList;
import java.util.List;

import org.pontis.hackathon.ApiException;
import org.pontis.hackathon.textanalytics.client.api.DefaultApi;
import org.pontis.hackathon.textanalytics.client.model.KeyPhraseBatchResultV2;
import org.pontis.hackathon.textanalytics.client.model.MultiLanguageBatchInputV2;
import org.pontis.hackathon.textanalytics.client.model.MultiLanguageInputV2;

public class TextAnalyticsClientUtil {
	
	private final static DefaultApi api = new DefaultApi();
	private final static String ocpApimSubscriptionKey = "9aa00ea97c5e4753b97e54507f9eb03b";
	private final static String subscriptionKey = ocpApimSubscriptionKey;
	
	public static List<String> getKeyPhrases(String input) {
		List<String> result = null;
        MultiLanguageBatchInputV2 multiLanguageBatchInputV2 = new MultiLanguageBatchInputV2();
        List<MultiLanguageInputV2> documents = new ArrayList<>();
        MultiLanguageInputV2 document = new MultiLanguageInputV2();
        document.setLanguage("en");
        document.setId("goat");
        document.setText(input);
		documents.add(document);
		multiLanguageBatchInputV2.setDocuments(documents);
        KeyPhraseBatchResultV2 response;
		try {
			response = api.keyPhrases(subscriptionKey, ocpApimSubscriptionKey, multiLanguageBatchInputV2);
			result = response.getDocuments().get(0).getKeyPhrases();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

}
