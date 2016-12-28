package com.batsw.tor_expert_bundle_controller.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {
    public final static Logger log = LogManager.getLogger(FileHandler.class);
    private static final String CLASS_NAME = FileHandler.class.getName();

    static public String readFile(String filePath) {
        log.debug("Reading file: " + filePath);
        String fileContent = "";
        Path path = Paths.get(filePath);
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                fileContent += line;
            }
            return fileContent;
        } catch (IOException ex) {
            log.debug("IOException: %s%n", ex);
            log.info("Canot open " + filePath);
            return null;
        }
    }

    static public ArrayList<String> readFileByLine(String filePath) {
        log.debug("Reading file: " + filePath);
        ArrayList<String> fileContent = new ArrayList<>();
        Path path = Paths.get(filePath);
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                fileContent.add(line);
            }
            return fileContent;
        } catch (IOException ex) {
            log.debug("IOException: %s%n", ex);
            log.info("Canot open " + filePath);
            return null;
        }
    }

    static public Boolean verifyIfFolderExists(String path) {
        File fileTester = new File(path);
        return (fileTester.isDirectory() && fileTester.exists());
    }

    static public Boolean verifyIfFileExists(String path) {
        File fileTester = new File(path);
        return (fileTester.exists() && !fileTester.isDirectory());
    }

    static public Boolean writeToFile(String filePath, String fileContent) {
        log.debug("Writhing file: " + filePath);
        File fileHandler = new File(filePath);

        try {
            if (!fileHandler.exists()) {
                fileHandler.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(fileHandler.getAbsoluteFile());
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write(fileContent);
            writer.close();
            log.info("Created file " + filePath);
            return true;
        } catch (IOException ex) {
            log.debug("IOException: %s%n", ex);
            log.info("Cannot open " + filePath);
            return false;
        }
    }
}