package com.batsw.tor_expert_bundle_controller.common;

public class Constanst {
	public static final String TORCHATCFG_FILENAME = "torchatcfg.json";
	public static final String TORRC_FILENAME = "torrc";
	public static final String CONFIGURATION_FILE_LOCATION = ".";
	public static final String CONFIGURATION_FILE_DEFAULT_LOCATION = ".";

	public static final String EMPTY_STRING = "";

	// NOTE: due to problems regarding extracting resource files from a jar
	// The default configurations were move to 2 strings variables
	public static final String TORCHATCFG_DEFAULT_CONTNET =
			"{\n"                                            					+
					"\t\"torBundle\":\n"                       					+
					"\t{\n"                                    					+
				      	"\t\t\"executableName\": \"tor.exe\",\n"          		+
						"\t\t\"configurationFilename\":	\"torrc\",\n"     		+
						"\t\t\"executablePath\": \"./Bundle/Tor\",\n"     		+
						"\t\t\"configurationFilePath\": \".\",\n"          		+
						"\t\t\"hiddenServicePath\":	\"./hidden_service\"\n"		+
					"\t}\n"														+
			"}";

	public static final String TORRC_DEFAULT_CONTNET =
			"# DEFAULT FILE\n" +
			"# Configuration files and folder location\n" 										+
			"DataDirectory ./Bundle/Data/Tor\n"													+
			"GeoIPFile ./Bundle/Data/Tor/geoip\n"												+
			"GeoIPv6File ./Bundle/Data/Tor/geoip6\n"											+
			"HiddenServiceStatistics 0\n"														+
			"# Port used to send request\n"														+
			"SocksPort 11158\n"																	+
			"# Directory were the hostname and the private key are stored\n"					+
			"HiddenServiceDir ./Bundle/Data/Tor/hidden_service/\n"								+
			"# The port on which the server is listening\n"										+
			"# Example:\n"																		+
			"# All traffic coming on port 80 will be routed to port 8080 of the local proxy\n"	+
			"HiddenServicePort 80 127.0.0.1:8080";
}