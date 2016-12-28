package com.batsw.tor_expert_bundle_controller.service.impl;


import com.batsw.tor_expert_bundle_controller.model.TorProcessModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  Provides methods to get absolute paths for tor locations
 *  Replace . with current working directory
 */
public class FilePathService {
    public static final Logger log = LogManager.getLogger(FilePathService.class);
    public FilePathService() {}

    public TorProcessModel getTorAbsolutePaths(TorProcessModel  processInfo) {
        log.info("Setting absolute path for bundle");
        TorProcessModel result = new TorProcessModel();
        result.setConfigurationFilePath(setAbsolutePath(processInfo.getConfigurationFilePath()));
        result.setHiddenServicePath(setAbsolutePath(processInfo.getHiddenServicePath()));
        result.setCommandPath(setAbsolutePath(processInfo.getCommandPath()));
        result.setConfigurationFilename(processInfo.getConfigurationFilename());
        result.setCommandArguments(processInfo.getCommandArguments());
        result.setCommandName(processInfo.getCommandName());
        return result;
    }

    public String setAbsolutePath(String pathToCheck) {
        String currentPath = System.getProperty("user.dir");
        String relative, absolutePath, windowsPath;
        String relativePathIndicator = ".";
        if (!pathToCheck.isEmpty()) {
            relative = pathToCheck.substring(0,1);
            if (relative.equals(relativePathIndicator)){
                absolutePath = pathToCheck.replace(relativePathIndicator, currentPath );
                windowsPath =  absolutePath.replace("/", "\\");
                System.out.println(windowsPath);
                return windowsPath;
            }
            return pathToCheck;
        }
        return "";
    }
}