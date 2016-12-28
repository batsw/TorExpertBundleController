package com.batsw.tor_expert_bundle_controller.model;

/**
 *  The model describes the propertirs of Tor bundle expert
 */
public class TorProcessModel extends ProcessModel {
		
	private String mConfigurationFilename;
	private String mConfigurationFilePath;
	private String mHiddenServicePath;
	
	public TorProcessModel() {}
	
	public TorProcessModel(String mCommandName, String mCommandPath, String mCommandArguments,
			String mConfigurationFilename, String mConfigurationFilePath, String mHiddenServicePath) {
		super(mCommandName, mCommandPath, mCommandArguments);
		this.mConfigurationFilename = mConfigurationFilename;
		this.mConfigurationFilePath = mConfigurationFilePath;
		this.mHiddenServicePath = mHiddenServicePath;
	}

	public String getConfigurationFilename() {
		return mConfigurationFilename;
	}

	public void setConfigurationFilename(String mConfigurationFilename) {
		this.mConfigurationFilename = mConfigurationFilename;
	}

	public String getConfigurationFilePath() {
		return mConfigurationFilePath;
	}

	public void setConfigurationFilePath(String mConfigurationFilePath) {
		this.mConfigurationFilePath = mConfigurationFilePath;
	}

	public String getHiddenServicePath() {
		return mHiddenServicePath;
	}

	public void setHiddenServicePath(String mHiddenServicePath) {
		this.mHiddenServicePath = mHiddenServicePath;
	}
}