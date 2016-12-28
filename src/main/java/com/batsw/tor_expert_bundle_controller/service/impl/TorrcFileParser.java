package com.batsw.tor_expert_bundle_controller.service.impl;

import com.batsw.tor_expert_bundle_controller.model.TorBundleInformation;
import com.batsw.tor_expert_bundle_controller.service.i.IParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Provides a method to parse the contents of torrc file
 */
public class TorrcFileParser implements IParser<TorBundleInformation> {
	public final static Logger log = LogManager.getLogger(TorrcFileParser.class);
	final private String SOCKS_PORT = "SocksPort";
	final private String HIDDEN_SERVICE_PORT = "HiddenServicePort";
	final private String HIDDEN_SERVICE_DIRECTORY = "HiddenServiceDir";
	
	public TorBundleInformation parse(String configurationFileData) {
		if (configurationFileData == null || configurationFileData.isEmpty()) {
			return null;
		}
		log.info("Extracting information from torrc file");
		TorBundleInformation result = new TorBundleInformation();
		try{
			String newLineSeparator = configurationFileData.contains("\r\n") ? "\r\n" : "\n";
			String[] configurationFileSplitData = configurationFileData.split(newLineSeparator);
			for (String item:configurationFileSplitData)
			{
				if (item.contains(SOCKS_PORT)) {
					String[] words = item.split(" ");
					result.setSocksPort(words[1]);
					log.info("SocksPort " + result.getSocksPort());
				}
				if (item.contains(HIDDEN_SERVICE_PORT)) {
					String[] words = item.split(":");
					result.setHiddenServicePort(words[1]);
					log.info("HiddenServicePort " + result.getHiddenServicePort());
				}
				if (item.contains(HIDDEN_SERVICE_DIRECTORY)) {
					String[] words = item.split(" ");
					result.setHiddenServiceDir(words[1]);
					log.info("HiddenServiceDir " + result.getHiddenServiceDir());
				}
			}
			return result;
		} catch (Exception e) {
			log.error("Cannot parser torrc file \nException:\n" + e.getMessage());
			return  null;
		}


	}
}
