package org.hackathon.fetchers.twitter;

import java.util.List;

public interface ISocialGetter {
	public List<SocialMessage> getNextMessages();
}
