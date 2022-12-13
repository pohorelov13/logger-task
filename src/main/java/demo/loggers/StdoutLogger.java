package demo.loggers;

import demo.LoggingLevel;
import demo.configurations.LoggerConfiguration;
import demo.configurations.StdoutLoggerConfiguration;
import demo.utils.Formatter;

public class StdoutLogger extends Logger {
    @Override
    public void debug(String debugMessage, String infoMessage) {
        LoggerConfiguration configuration = new StdoutLoggerConfiguration();
        configuration.setLevel(LoggingLevel.INFO);
        printLog(configuration, infoMessage);
        configuration.setLevel(LoggingLevel.DEBUG);
        printLog(configuration, debugMessage);
    }

    @Override
    public void debug(String message) {
        LoggerConfiguration configuration = new StdoutLoggerConfiguration();
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
        LoggerConfiguration configuration = new StdoutLoggerConfiguration();
        configuration.setLevel(LoggingLevel.INFO);
        printLog(configuration, message);
    }

    @Override
    public void printLog(LoggerConfiguration configuration, String message) {
        System.out.print(Formatter.formatter(configuration.getTime(),
                configuration.getLevel().name(), message,
                configuration.getFormat()));
    }

    @Override
    public void doLogging(LoggerConfiguration configuration, String debugMessage, String infoMessage) {
        switch (configuration.getLevel()) {
            case INFO -> info(configuration, infoMessage);
            case DEBUG -> debug(configuration, debugMessage, infoMessage);
        }
    }

}
