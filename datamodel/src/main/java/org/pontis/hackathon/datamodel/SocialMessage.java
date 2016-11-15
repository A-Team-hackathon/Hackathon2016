package org.pontis.hackathon.datamodel;

import java.util.Date;

public class SocialMessage {
	Date timeStamp;
	String messageId;
	String messageText;
	String fromUser;
	ExternalIdType externalIdType;
	Long prevMessageId;
	String prevMessageSender;
	Integer messagePopularity;
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public ExternalIdType getExternalIdType() {
		return externalIdType;
	}

	public void setExternalIdType(ExternalIdType externalIdType) {
		this.externalIdType = externalIdType;
	}

	public Long getPrevMessageId() {
		return prevMessageId;
	}

	public void setPrevMessageId(Long prevMessageId) {
		this.prevMessageId = prevMessageId;
	}

	public String getPrevMessageSender() {
		return prevMessageSender;
	}

	public void setPrevMessageSender(String prevMessageSender) {
		this.prevMessageSender = prevMessageSender;
	}

	public Integer getMessagePopularity() {
		return messagePopularity;
	}

	public void setMessagePopularity(Integer messagePopularity) {
		this.messagePopularity = messagePopularity;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(timeStamp.toString()).append(" msgId=").append(messageId).append(" prevMsgId=").append(prevMessageId);
		sb.append("from: ").append(fromUser).append(" prevUser=").append(prevMessageSender);
		sb.append("popularity=").append(messagePopularity).append(" ");
		sb.append(messageText).append('\n');
		return sb.toString();
	}
}