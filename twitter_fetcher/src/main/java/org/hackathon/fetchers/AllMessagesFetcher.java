package org.hackathon.fetchers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.hackathon.fetchers.twitter.TweetFetcher;
import org.pontis.hackathon.datamodel.SocialMessage;

public class AllMessagesFetcher {
	public static void main(String[] args) throws IOException {
		FileOutputStream fs = new FileOutputStream("twitter.csv");
		fs.write(SocialMessage.HEADER.getBytes());
		TweetFetcher f = new TweetFetcher(null);
		List<SocialMessage> msgs = f.getNextMessages();
		for (SocialMessage sm : msgs) {
			fs.write(sm.toCSV().getBytes());
		}
		fs.close();
		
		fs = new FileOutputStream("facebook.csv");
		fs.write(SocialMessage.HEADER.getBytes());
		f = new TweetFetcher(null);
		msgs = f.getNextMessages();
		for (SocialMessage sm : msgs) {
			fs.write(sm.toCSV().getBytes());
		}
		fs.close();
	}
}
