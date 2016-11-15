package org.hackathon.fetchers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.hackathon.fetchers.facebook.FacebookFetcher;
import org.hackathon.fetchers.twitter.TweetFetcher;
import org.pontis.hackathon.datamodel.SocialMessage;

public class AllMessagesFetcher {
	public static void main(String[] args) throws IOException {
		FileOutputStream fs = new FileOutputStream("twitter.csv");
		try {
			fs.write(SocialMessage.HEADER.getBytes());
			TweetFetcher f = new TweetFetcher(null);
			List<SocialMessage> msgs = f.getNextMessages();
			for (SocialMessage sm : msgs) {
				fs.write(sm.toCSV().getBytes());
			}
		} finally {
			fs.close();
		}

		FileOutputStream fs2 = new FileOutputStream("facebook.csv");
		try {
			fs2.write(SocialMessage.HEADER.getBytes());
			FacebookFetcher f = new FacebookFetcher();
			List<SocialMessage> msgs = f.getNextMessages();
			for (SocialMessage sm : msgs) {
				fs2.write(sm.toCSV().getBytes());
			}
		} finally {
			fs2.close();
		}
	}
}
