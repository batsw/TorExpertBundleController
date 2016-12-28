package com.batsw.tor_expert_bundle_controller.service.impl;

import com.batsw.tor_expert_bundle_controller.common.FileHandler;
import com.batsw.tor_expert_bundle_controller.common.ReturnValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  Provides methods for finding  and reading the hostname of the tor bundle
 */
public class HiddenServiceReader {
	public final static Logger log = LogManager.getLogger(HiddenServiceReader.class);
	private String hiddenServiceDirectory;
	private final String HOSTNAME_FILE = "hostname";
	private final String PRIVATE_KEY_FILE = "private_key";
	
	public HiddenServiceReader(String path) {
		hiddenServiceDirectory = path;
	}
	
	public ReturnValue getHiddenServiceStatus() {
		log.info("Hidden service location ", hiddenServiceDirectory);
		ReturnValue returnValue = new ReturnValue();
		if(!FileHandler.verifyIfFolderExists(hiddenServiceDirectory)) {
			returnValue.Add("Hidden service directory not found");
			log.error("Hidden Service directory not found verify  torrc file");
			returnValue.setSuccess(false);
		}
		else {
			if (!(FileHandler.verifyIfFileExists(hiddenServiceDirectory + "\\" + HOSTNAME_FILE) &&
				FileHandler.verifyIfFileExists(hiddenServiceDirectory +  "\\" + PRIVATE_KEY_FILE))) {
				returnValue.Add("Hidden Service directory is empty");
				log.error("Hidden Service directory empty");
				returnValue.setSuccess(false);
			}
		}
		return returnValue;
	}		
	public String getHostname() {
		ReturnValue hiddenServiceStatus = getHiddenServiceStatus();
		log.info("Searching for  file " + HOSTNAME_FILE + " in " + hiddenServiceDirectory);
		if (hiddenServiceStatus.getSuccess()) {

			return FileHandler.readFile(hiddenServiceDirectory + "\\" + HOSTNAME_FILE);
		}
		return null;
	}
	public String getKey(){
		ReturnValue hiddenServiceStatus = getHiddenServiceStatus();
		if (hiddenServiceStatus.getSuccess()) {
			return FileHandler.readFile(hiddenServiceDirectory + "\\" + PRIVATE_KEY_FILE);
		}
		return null;
	}
}