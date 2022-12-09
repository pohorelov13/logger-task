package demo.loggers;

import demo.utils.Formatter;
import demo.LoggingLevel;
import demo.configurations.LoggerConfiguration;

import java.io.*;


public class FileLogger extends Logger {

    public void doLogging(LoggerConfiguration configuration, String message) {
        switch (configuration.getLevel()) {
            case INFO -> {
                printLog(configuration, message);
            }
            case DEBUG -> {
                printLog(configuration, message);
                configuration.setLevel(LoggingLevel.INFO);
                printLog(configuration, message);
            }
        }
    }


    @Override
    public void printLog(LoggerConfiguration configuration, String message) {
        configuration.setMessage(message);
        File file = configuration.prepare();
        try (FileOutputStream fos = new FileOutputStream(file, true);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write((Formatter.formatter(configuration.getTime(),
                    configuration.getLevel().name(), configuration.getMessage(), configuration.getFormat()).getBytes()));
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}