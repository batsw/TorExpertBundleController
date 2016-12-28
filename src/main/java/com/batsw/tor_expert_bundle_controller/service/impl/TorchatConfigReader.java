package com.batsw.tor_expert_bundle_controller.service.impl;

import com.batsw.tor_expert_bundle_controller.common.Constanst;
import com.batsw.tor_expert_bundle_controller.service.i.IConfigurationReader;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

/**
 *  Provides methods for finding and reading tor configuration files
 *  Example configuration filename: torchatcfg.json, torrc
 */
public class TorchatConfigReader implements IConfigurationReader {
	public  static final Logger log = LogManager.getLogger(TorchatConfigReader.class);

	public String getConfigurationFile (String path, String name){
		log.info("Loading from" + path + " file: " + name);
		String content;
		String file= path + "\\" + name;
		content = getFile(file);
		if (content == null || content.isEmpty())
		{
			return  null;
		}
		return content;
	}

	public String getDefaultConfigurationFile(String name){
		if (name.equals(Constanst.TORCHATCFG_FILENAME)) {
			log.warn("Using default " + Constanst.TORCHATCFG_FILENAME);
			return Constanst.TORCHATCFG_DEFAULT_CONTNET ;
		}
		if (name.equals(Constanst.TORRC_FILENAME)) {
			log.warn("Using default " + Constanst.TORRC_DEFAULT_CONTNET);
			return Constanst.TORRC_DEFAULT_CONTNET;
		}
		return null;
	}

	public String getFile (String path) {
		try {

			log.info("Reading file " + path);
			String windowsPath = path.replaceAll("/","\\");
			File currentFile = new File(windowsPath);
			if (currentFile.exists() && !currentFile.isDirectory()) {
				String stringConfigFile = new Scanner(currentFile, "UTF-8").useDelimiter("\\A").next();
				return stringConfigFile;
			}
			else {
				log.error("Cannot open file");
				return null;
			}
		} catch (Exception e) {
			log.error("Cannot open file \n Exception: "+ e.getMessage() );
			return null;
		}
	}
}
