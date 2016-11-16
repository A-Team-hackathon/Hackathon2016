package org.pontis.hackathon.service;

import org.pontis.hackathon.datamodel.ExternalIdType;
import org.pontis.hackathon.datamodel.User;

public interface InternalUserResolver {
	User resolveUser(ExternalIdType idType, String externalId);
}
