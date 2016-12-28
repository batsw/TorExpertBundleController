package com.batsw.tor_expert_bundle_controller.model;

/**
 *  Stores the relevant information from the torrc file
 */
public class TorBundleInformation {
	
	private String mSocksPort;
	private String mHiddenServicePort;
	private String mHiddenServiceDir;
	public TorBundleInformation (){}
	public TorBundleInformation(String mSocksPort, String mHiddenServicePort, String mHiddenServiceDir) {
		super();
		this.mSocksPort = mSocksPort;
		this.mHiddenServicePort = mHiddenServicePort;
		this.mHiddenServiceDir = mHiddenServiceDir;
	}

	public String getSocksPort() {
		return mSocksPort;
	}

	public void setSocksPort(String mSocksPort) {
		this.mSocksPort = mSocksPort;
	}

	public String getHiddenServicePort() {
		return mHiddenServicePort;
	}

	public void setHiddenServicePort(String mHiddenServicePort) {
		this.mHiddenServicePort = mHiddenServicePort;
	}

	public String getHiddenServiceDir() {
		return mHiddenServiceDir;
	}

	public void setHiddenServiceDir(String mHiddenServiceDir) {
		this.mHiddenServiceDir = mHiddenServiceDir;
	}
}
