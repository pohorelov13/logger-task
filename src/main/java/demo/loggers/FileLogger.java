package demo.loggers;

import demo.configurations.FileLoggerConfiguration;
import demo.utils.Formatter;
import demo.LoggingLevel;
import demo.configurations.LoggerConfiguration;

import java.io.*;


public class FileLogger extends Logger {

    @Override
    public void printLog(LoggerConfiguration configuration, String message) {
        File file = configuration.prepare();
        try (BufferedOutputStream bos = new BufferedOutputStream
                (new FileOutputStream(file, true))) {
            bos.write((Formatter.formatter(configuration.getTime(),
                    configuration.getLevel().name(), message,
                    configuration.getFormat()).getBytes()));
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}