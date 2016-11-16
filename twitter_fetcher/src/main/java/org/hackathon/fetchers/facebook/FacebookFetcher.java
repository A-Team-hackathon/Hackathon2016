package org.hackathon.fetchers.facebook;

import java.util.ArrayList;
import java.util.List;

import org.hackathon.fetchers.ISocialGetter;
import org.pontis.hackathon.datamodel.SocialMessage;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

public class FacebookFetcher implements ISocialGetter {
	FacebookTemplate facebook;

	public FacebookFetcher() {
		facebook = new FacebookTemplate("1333151753375457|NesbSrkWA-SLx_n9ZBRCBPB8paI");

	}


	public static void main(String[] args) {
		FacebookFetcher f = new FacebookFetcher();
		f.getNextMessages();
	}

	private SocialMessage tweetToMessage(Post message) {
		SocialMessage result = new SocialMessage();
		result.setFromUser(message.getFrom().getName());
		
		result.setMessageId(message.getId());
		result.setMessageText(message.getMessage());

		result.setTimeStamp(message.getCreatedTime());
		result.setMessagePopularity(message.getShares());

		return result;
	}


	public List<SocialMessage> getNextMessages() {
		List<SocialMessage> result = new ArrayList<SocialMessage>();
		PagingParameters pp = new PagingParameters(100, 0, null, null);

		List<Post> pages = facebook.feedOperations().getFeed("ATT", pp);
		for (Post p : pages) {
			result.add(tweetToMessage(p));
			System.out.println(p.getCreatedTime() + "(" + p.getShares() + " shares) " + p.getFrom().getName() + ": "
					+ p.getMessage());
		}

		return result;
	}

}
