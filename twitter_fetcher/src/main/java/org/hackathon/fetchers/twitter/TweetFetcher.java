package org.hackathon.fetchers.twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hackathon.fetchers.ISocialGetter;
import org.pontis.hackathon.datamodel.SocialMessage;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchParameters.ResultType;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class TweetFetcher implements ISocialGetter {
	private TwitterTemplate twitter = null;
	private String channelToFollow = "ATTCares";
	String privateKey = "g2cBKpKEOhPtJo01xUR4WbDXW";
	String secret = "O8JAl8aQ0JN8ROXq2q3MMRJliongRM8FWGWAs2mUDWkcJ9VCGl";
	long lastRecievedmMessageId = Long.MAX_VALUE;

	public TweetFetcher(String channelToFollow) {
		twitter = new TwitterTemplate(privateKey, secret);
		if (channelToFollow != null) {
			this.channelToFollow = channelToFollow;
		}
	}

	private SocialMessage tweetToMessage(Tweet message) {
		SocialMessage result = new SocialMessage();
		result.setFromUser(message.getFromUser());
		result.setMessageId(String.valueOf(message.getId()));
		result.setMessageText(message.getText());

		result.setPrevMessageId(message.getInReplyToStatusId());
		result.setPrevMessageSender(message.getInReplyToScreenName());

		result.setTimeStamp(message.getCreatedAt());
		result.setMessagePopularity(message.getRetweetCount());
		return result;
	}

	private void getTweetsInReplayFor(Map<String, List<Tweet>> tweetCache, String user, long messageId,
			List<SocialMessage> result) {
		List<Tweet> tweets = tweetCache.get(user);
		if (tweets == null) {
			SearchParameters sp = new SearchParameters("from:" + user);
			sp.resultType(ResultType.RECENT);
			sp.count(100);
			// sp.maxId(messageId);
			SearchResults sr = twitter.searchOperations().search(sp);
			tweets = sr.getTweets();
			tweetCache.put(user, tweets);
		}
		for (Tweet t2 : tweets) {
			if (t2.getId() == messageId) {
				result.add(this.tweetToMessage(t2));

				if (t2.getInReplyToStatusId() != null) {
					getTweetsInReplayFor(tweetCache, t2.getInReplyToScreenName(), t2.getInReplyToStatusId(), result);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TweetFetcher tf = new TweetFetcher(null);
		// while (true) {
		// long startTime = System.currentTimeMillis();
		// System.out.println("getNextMessages");
		// List<SocialMessage> result = tf.getNextMessages();
		// System.out.println("Query took " + (System.currentTimeMillis() -
		// startTime) + " and returned " + result.size());
		// if (!result.isEmpty()) {
		// for (SocialMessage sm : result) {
		// System.out.println(sm.getMessageText());
		// }
		// //break;
		// }
		//
		// try {
		// Thread.currentThread().sleep(30000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

	}

	public List<SocialMessage> getNextMessages() {
		List<SocialMessage> result = new ArrayList<SocialMessage>();
		// SearchParameters sp = new SearchParameters("from:" +
		// channelToFollow);
		// sp.sinceId(lastRecievedmMessageId);
		// sp.count(100);
		// sp.lang("en");

		SearchResults sr = twitter.searchOperations().search("to:" + channelToFollow, 100, 0L,
				lastRecievedmMessageId);
		for (int i = 0; i < 100; i++) {
			List<Tweet> tweets = sr.getTweets();
			System.out.println("found " + tweets.size());
			//Map<String, List<Tweet>> tweetCache = new HashMap<String, List<Tweet>>();
			for (Tweet t : tweets) {
				if (t.getLanguageCode().equals("en")) {
					result.add(tweetToMessage(t));
					if (t.getId() < lastRecievedmMessageId) {
						lastRecievedmMessageId = t.getId();
					}
//					if (t.getInReplyToStatusId() != null) {
//						getTweetsInReplayFor(tweetCache, t.getInReplyToScreenName(), t.getInReplyToStatusId(), result);
//					}
				}
			}
			System.out.println("get next values");
			sr = twitter.searchOperations().search("to:" + channelToFollow, 100, 0L, lastRecievedmMessageId - 1);
			if (sr.getTweets().isEmpty()) {
				break;
			}
		}
		lastRecievedmMessageId = Long.MAX_VALUE;
		sr = twitter.searchOperations().search("from:" + channelToFollow, 100, 0L,
				lastRecievedmMessageId);
		for (int i = 0; i < 100; i++) {
			List<Tweet> tweets = sr.getTweets();
			System.out.println("found " + tweets.size());
			//Map<String, List<Tweet>> tweetCache = new HashMap<String, List<Tweet>>();
			for (Tweet t : tweets) {
				if (t.getLanguageCode().equals("en")) {
					result.add(tweetToMessage(t));
					if (t.getId() < lastRecievedmMessageId) {
						lastRecievedmMessageId = t.getId();
					}
//					if (t.getInReplyToStatusId() != null) {
//						getTweetsInReplayFor(tweetCache, t.getInReplyToScreenName(), t.getInReplyToStatusId(), result);
//					}
				}
			}
			System.out.println("get next values");
			sr = twitter.searchOperations().search("from:" + channelToFollow, 100, 0L, lastRecievedmMessageId - 1);
			if (sr.getTweets().isEmpty()) {
				break;
			}
		}

		return result;
	}

}
