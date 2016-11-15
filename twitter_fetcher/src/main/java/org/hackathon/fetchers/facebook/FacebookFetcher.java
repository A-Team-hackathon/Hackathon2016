package org.hackathon.fetchers.facebook;

import java.util.ArrayList;
import java.util.List;

import org.hackathon.fetchers.ISocialGetter;
import org.pontis.hackathon.datamodel.SocialMessage;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

public class FacebookFetcher implements ISocialGetter {
	FacebookTemplate facebook;

	public FacebookFetcher() {
		facebook = new FacebookTemplate("1333151753375457|NesbSrkWA-SLx_n9ZBRCBPB8paI");

	}

	private SocialMessage tweetToMessage(Post message) {
		SocialMessage result = new SocialMessage();
		result.setFromUser(message.getFrom().getName());

		result.setMessageId(message.getId());
		String txt = message.getMessage();
		result.setMessageText(txt == null ? "" : txt);

		result.setTimeStamp(message.getCreatedTime());
		result.setMessagePopularity(message.getShares());

		return result;
	}

	public List<SocialMessage> getNextMessages() {
		
		List<SocialMessage> result = new ArrayList<SocialMessage>();
		PagingParameters pp = new PagingParameters(100, 0, null, null);
		for (int i = 0; i < 10000; i += 100) {			

			PagedList<Post> pages = facebook.feedOperations().getFeed("ATT", pp);
			System.out.println(i + ": " + pages.size());
			for (Post p : pages) {
				result.add(tweetToMessage(p));
			}
			if (pages.isEmpty()) {
				break;
			}
			pp = pages.getNextPage();
			if (pp== null) {
				break;
			}
			
		}
		return result;
	}

}
