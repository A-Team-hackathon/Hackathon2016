package ateam.service;

import java.util.List;

import ateam.data.SocialMessage;
import ateam.data.User;

public class ImportServiceImpl implements ImportService {
	
	private InternalUserResolver internalUserResolver;
	
	@Override
	public void importData(List<SocialMessage> importData) {
		for(final SocialMessage data : importData){
			User user = internalUserResolver.resolveUser(data.getExternalIdType(), data.getFromUser());
		}
	}

}
