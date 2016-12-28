package com.batsw.tor_expert_bundle_controller.model;

/**
 *  Describes the model of an external process that will lbe launched
 */
public class ProcessModel {

	private String mCommandName;
	private String mCommandPath;
	private String mCommandArguments;
	
	public ProcessModel() {}
	public ProcessModel(String mCommandName, String mCommandPath, String mCommandArguments) {
		super();
		this.mCommandName = mCommandName;
		this.mCommandPath = mCommandPath;
		this.mCommandArguments = mCommandArguments;
	}

	public String getCommandName() {
		return mCommandName;
	}
	
	public void setCommandName(String mCommandName) {
		this.mCommandName = mCommandName;
	}
	
	public String getCommandPath() {
		return mCommandPath;
	}
	
	public void setCommandPath(String mCommandPath) {
		this.mCommandPath = mCommandPath;
	}
	
	public String getCommandArguments() {
		return mCommandArguments;
	}
	
	public void setCommandArguments(String mCommandArguments) {
		this.mCommandArguments = mCommandArguments;
	}
	
	@Override
	public String toString() {
		return "ProcessModel [mCommandName=" + mCommandName + ", mCommandPath=" + mCommandPath + ", mCommandArguments="
				+ mCommandArguments + "]";
	}
}