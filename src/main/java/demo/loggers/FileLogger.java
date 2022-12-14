package demo.loggers;

import demo.LoggingLevel;
import demo.utils.Formatter;
import demo.configurations.LoggerConfiguration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileLogger extends Logger {

    private final LoggerConfiguration configuration;
    private File file;

    public FileLogger(LoggerConfiguration configuration) {
        this.configuration = configuration;
    }


    @Override
    public void debug(String message) {
        if (configuration.getLevel() == LoggingLevel.DEBUG) {
            try {
                getLatestFileFromDir(configuration.getDirPath(), configuration);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (BufferedOutputStream bos = new BufferedOutputStream
                    (new FileOutputStream(file, true))) {
                bos.write((Formatter.formatter(configuration.getTime(),
                        LoggingLevel.DEBUG.name(), message,
                        configuration.getFormat()).getBytes()));
                bos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void info(String message) {
        //  if (configuration.getLevel() == LoggingLevel.DEBUG ||
        //   configuration.getLevel() == LoggingLevel.INFO) {
        try {
            getLatestFileFromDir(configuration.getDirPath(), configuration);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedOutputStream bos = new BufferedOutputStream
                (new FileOutputStream(file, true))) {
            bos.write((Formatter.formatter(configuration.getTime(),
                    LoggingLevel.INFO.name(), message,
                    configuration.getFormat()).getBytes()));
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getLatestFileFromDir(String dirPath, LoggerConfiguration configuration) throws IOException {
        File dir = new File(Files.createDirectories(Paths.get(configuration.getDirPath())).toString());
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            file = new File(dirPath + configuration.getLogName());
        } else {
            File lastModifiedFile = files[0];
            for (int i = 1; i < files.length; i++) {
                if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                    lastModifiedFile = files[i];
                }
            }
            file = lastModifiedFile;
        }
        if (file.length() > configuration.getSize()) {
            file = new File(dirPath + configuration.getLogName());
        }
    }
}