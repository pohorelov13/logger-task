package demo.loggers;

import demo.configurations.LoggerConfiguration;

public abstract class Logger {

    public abstract void printLog(LoggerConfiguration configuration, String message);
    public abstract void doLogging(LoggerConfiguration logger, String message);
}
