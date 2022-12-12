package demo.loggers;

import demo.LoggingLevel;
import demo.configurations.LoggerConfiguration;

public abstract class Logger {

    public abstract void printLog(LoggerConfiguration configuration, String message);
    public void doLogging(LoggerConfiguration configuration, String message){
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
}
