package org.pontis.hackathon.service;

import java.util.List;

import org.pontis.hackathon.datamodel.SocialMessage;
import org.pontis.hackathon.datamodel.User;

public class ImportServiceImpl implements ImportService {
	
	private InternalUserResolver internalUserResolver;
	
	@Override
	public void importData(List<SocialMessage> importData) {
		for(final SocialMessage data : importData){
			User user = internalUserResolver.resolveUser(data.getExternalIdType(), data.getFromUser());
		}
	}

}
