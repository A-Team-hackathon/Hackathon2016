package org.hackathon.fetchers.twitter;

import java.util.List;

import org.pontis.hackathon.datamodel.SocialMessage;

public interface ISocialGetter {
	public List<SocialMessage> getNextMessages();
}
