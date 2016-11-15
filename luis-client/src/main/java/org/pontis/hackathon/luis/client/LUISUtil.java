package org.pontis.hackathon.luis.client;

import java.util.ArrayList;
import java.util.List;

public class LUISUtil {
	private final static String appId = "ad3678e2-9e94-4d8d-973b-4600f714a0a5";
	private final static String appKey = "587104670a714654a2376bbd58115095";
	private final static ThreadLocal<LUISClient> client = new ThreadLocal<LUISClient>() {

		@Override
		protected LUISClient initialValue() {
			return new LUISClient(appId, appKey, true, true);
		}
	};
	private static final double THRESHOLD = 0.8;

	public static String getTopIntent(String input) {
		String result = null;
		try {
			LUISResponse response = client.get().predict(input);
			LUISIntent topIntent = response.getTopIntent();
			if (topIntent != null && topIntent.getScore() > THRESHOLD) {
				result = topIntent.getName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<String> getEntities(String input) {
		List<String> result = new ArrayList<>();
		try {
			LUISResponse response = client.get().predict(input);
			for (LUISEntity luisEntity : response.getEntities()) {
				if (!luisEntity.getType().startsWith("builtin") && luisEntity.getScore() > THRESHOLD) {
					result.add(luisEntity.getType());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static IntentAndEntities getTopIntentAndEntities(String input) {
		IntentAndEntities result = new IntentAndEntities();
		try {
			LUISResponse response = client.get().predict(input);
			LUISIntent topIntent = response.getTopIntent();
			if (topIntent != null && topIntent.getScore() > THRESHOLD) {
				result.intent = topIntent.getName();
			}

			for (LUISEntity luisEntity : response.getEntities()) {
				if (!luisEntity.getType().startsWith("builtin") && luisEntity.getScore() > THRESHOLD) {
					result.entities.add(luisEntity.getType());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static class IntentAndEntities {
		public String intent;
		public List<String> entities = new ArrayList<>();
	}
}
