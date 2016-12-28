package com.batsw.tor_expert_bundle_controller.service.impl;

import com.batsw.tor_expert_bundle_controller.model.TorProcessModel;
import com.batsw.tor_expert_bundle_controller.service.i.IParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Provides a method to parse the contents of torchatcfg.json file
 */
public class TorchatcfgParser implements IParser<TorProcessModel> {
		
	public  final static Logger log = LogManager.getLogger(TorchatcfgParser.class);
	
	private JSONObject extractJsonObject(String data)
	{
		log.debug("Start creating JSON object");
		log.info("Data " , data );
		JSONParser parser = new JSONParser();
		Object rawData;
		try {

			rawData = parser.parse(data);
			JSONObject jsonElememnt =(JSONObject)rawData;
		    JSONObject jsonObject = (JSONObject)jsonElememnt.get("torBundle");
		    log.debug("Creating JSON object done");
		    return jsonObject;
		} catch (ParseException ex) {
			log.debug("ParseException: %s%n", ex);
			log.info("Cannot create JSON object:  " );
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see torchat.bundle.Service.IParser#parse(java.lang.String)
	 */
	public TorProcessModel parse(String data){
		log.debug("Start parsing JSON data");
		TorProcessModel parsedData = new TorProcessModel();
		JSONObject jsonObject= extractJsonObject(data);
		if (jsonObject == null) {
			return null;
		}
		try {
			parsedData.setCommandName(jsonObject.get("executableName").toString());
			parsedData.setConfigurationFilename(jsonObject.get("configurationFilename").toString());
			parsedData.setCommandPath(jsonObject.get("executablePath").toString());
			parsedData.setConfigurationFilePath(jsonObject.get("configurationFilePath").toString());
			parsedData.setHiddenServicePath(jsonObject.get("hiddenServicePath").toString());
			log.info("The following setting were found:"
					+ " \nexecutableName: " + parsedData.getCommandName() + "\n"
					+ "\nconfigurationFilename: " + parsedData.getConfigurationFilename() + "\n"
					+ "\nexecutablePath: " + parsedData.getConfigurationFilePath() + "\n"
					+ "\nconfigurationFilePath:" + parsedData.getConfigurationFilePath() + "\n"
					+ "\nhiddenServicePath" + parsedData.getHiddenServicePath() + "\n"); 
			log.debug("Parsing JSON done");
			return parsedData;
			
		} catch ( Exception e) {
			log.error("Cannot parse torchatcfg file");
			return null;
		}
	}
}