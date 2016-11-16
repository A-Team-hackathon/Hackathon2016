package ateam.service;

import ateam.data.ExternalIdType;
import ateam.data.User;

public interface InternalUserResolver {
	User resolveUser(ExternalIdType idType, String externalId);
}
