package org.pontis.hackathon.service;

import java.util.List;

import org.pontis.hackathon.datamodel.SocialMessage;

public interface DataProcessor {
	void process(List<SocialMessage> messages);
}
