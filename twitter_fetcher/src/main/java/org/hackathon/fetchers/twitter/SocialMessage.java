package org.hackathon.fetchers.twitter;

import java.util.Date;

public class SocialMessage {
	Date timeStamp;
	long messageId;
	String messageText;
	String fromUser;
	Long prevMessageId;
	String prevMessageSender;
	Integer messagePopularity;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(timeStamp.toString()).append(" msgId=").append(messageId).append(" prevMsgId=").append(prevMessageId);
		sb.append("from: ").append(fromUser).append(" prevUser=").append(prevMessageSender);
		sb.append("popularity=").append(messagePopularity).append(" ");
		sb.append(messageText).append('\n');
		return sb.toString();
	}
}
