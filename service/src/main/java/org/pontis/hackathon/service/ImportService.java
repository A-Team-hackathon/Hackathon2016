package org.pontis.hackathon.service;

import java.util.List;

import org.pontis.hackathon.datamodel.SocialMessage;

public interface ImportService {
	void importData(List<SocialMessage> importData);
}
