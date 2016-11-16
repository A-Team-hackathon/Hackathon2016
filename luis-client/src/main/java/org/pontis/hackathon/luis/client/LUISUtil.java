package org.pontis.hackathon.luis.client;

import java.util.List;

public class LUISUtil {
	private final static String appId = "ad3678e2-9e94-4d8d-973b-4600f714a0a5";
	private final static String appKey = "587104670a714654a2376bbd58115095";

	public static String getTopIntent(String input) {
		String result = null;
		LUISClient client = new LUISClient(appId, appKey, true, true);
		LUISResponse response;
		try {
			response = client.predict(input);
			LUISIntent topIntent = response.getTopIntent();
			if (topIntent != null) {
				result = topIntent.getName();
			}
//			System.out.println(response.getQuery());
//			for (LUISEntity luisEntity : response.getEntities()) {
//				System.out.println(luisEntity.getName());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
