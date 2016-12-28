package com.batsw.tor_expert_bundle_controller.common;

import java.util.ArrayList;

public class ReturnValue {
	private Boolean success;
	private ArrayList<String> messageList;
	
	public ReturnValue() {
		success = true;
		messageList = new ArrayList<String>();
	}
	
	public void  Add(String message) {
		if (!message.isEmpty()) {
			messageList.add(message);
		}
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public ArrayList<String> getMessageList() {
		return messageList;
	}
}

