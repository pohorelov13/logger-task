package demo.loggers;

import demo.LoggingLevel;
import demo.configurations.FileLoggerConfiguration;
import demo.configurations.LoggerConfiguration;

public abstract class Logger {

    public abstract void debug(String debugMessage, String infoMessage);
    public abstract void debug(String message);
    public abstract void debug(LoggerConfiguration configuration, String message);
    public abstract void debug(LoggerConfiguration configuration, String debugMessage, String infoMessage);
    public abstract void info(LoggerConfiguration configuration, String message);
    public abstract void info(String message);
    public abstract void printLog(LoggerConfiguration configuration, String message);

    public abstract void doLogging(LoggerConfiguration configuration, String debugMessage, String infoMessage);
}
