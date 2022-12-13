package demo.loggers;

import demo.LoggingLevel;
import demo.configurations.FileLoggerConfiguration;
import demo.utils.Formatter;
import demo.configurations.LoggerConfiguration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileLogger extends Logger {

    @Override
    public void debug(String debugMessage, String infoMessage) {
        LoggerConfiguration configuration = new FileLoggerConfiguration();
        configuration.setLevel(LoggingLevel.INFO);
        printLog(configuration, infoMessage);
        configuration.setLevel(LoggingLevel.DEBUG);
        printLog(configuration, debugMessage);
    }

    @Override
    public void debug(String message) {
        LoggerConfiguration configuration = new FileLoggerConfiguration();
        configuration.setLevel(LoggingLevel.INFO);
        printLog(configuration, message);
        configuration.setLevel(LoggingLevel.DEBUG);
        printLog(configuration, message);
    }

    @Override
    public void debug(LoggerConfiguration configuration, String message) {
        configuration.setLevel(LoggingLevel.INFO);
        printLog(configuration, message);
        configuration.setLevel(LoggingLevel.DEBUG);
        printLog(configuration, message);
    }

    @Override
    public void debug(LoggerConfiguration configuration, String debugMessage, String infoMessage) {
        configuration.setLevel(LoggingLevel.INFO);
        printLog(configuration, infoMessage);
        configuration.setLevel(LoggingLevel.DEBUG);
        printLog(configuration, debugMessage);
    }

    @Override
    public void info(LoggerConfiguration configuration, String message) {
        configuration.setLevel(LoggingLevel.INFO);
        printLog(configuration, message);
    }

    @Override
    public void info(String message) {
        LoggerConfiguration configuration = new FileLoggerConfiguration();
        configuration.setLevel(LoggingLevel.INFO);
        printLog(configuration, message);
    }

    @Override
    public void printLog(LoggerConfiguration configuration, String message) {
        try {
            getLatestFileFromDir(configuration.getDirPath(), configuration);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedOutputStream bos = new BufferedOutputStream
                (new FileOutputStream(configuration.getFile(), true))) {
            bos.write((Formatter.formatter(configuration.getTime(),
                    configuration.getLevel().name(), message,
                    configuration.getFormat()).getBytes()));
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getLatestFileFromDir(String dirPath, LoggerConfiguration configuration) throws IOException {
        File dir = new File(Files.createDirectories(Paths.get(configuration.getDirPath())).toString());//File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            configuration.setFile(new File(dirPath + configuration.getLogName()));
        } else {
            File lastModifiedFile = files[0];
            for (int i = 1; i < files.length; i++) {
                if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                    lastModifiedFile = files[i];
                }
            }
            configuration.setFile(lastModifiedFile);
        }
        if (configuration.getFile().length() > configuration.getSize()) {
            configuration.setFile(new File(dirPath + configuration.getLogName()));
        }
    }

    @Override
    public void doLogging(LoggerConfiguration configuration, String debugMessage, String infoMessage) {
        switch (configuration.getLevel()) {
            case INFO -> {
                info(configuration, infoMessage);
            }
            case DEBUG -> {
                debug(configuration, debugMessage, infoMessage);

            }
        }
    }

}