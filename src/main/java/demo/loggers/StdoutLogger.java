package demo.loggers;

import demo.LoggingLevel;
import demo.configurations.LoggerConfiguration;
import demo.utils.Formatter;

public class StdoutLogger extends Logger {

    LoggerConfiguration configuration;

    public StdoutLogger(LoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void debug(String message) {
        if (configuration.getLevel() == LoggingLevel.DEBUG) {
            System.out.print(Formatter.formatter(configuration.getTime(),
                    LoggingLevel.DEBUG.name(), message,
                    configuration.getFormat()));
        }
    }

    @Override
    public void info(String message) {
//        if (configuration.getLevel() == LoggingLevel.DEBUG ||
//                configuration.getLevel() == LoggingLevel.INFO) {
            System.out.print(Formatter.formatter(configuration.getTime(),
                    LoggingLevel.INFO.name(), message,
                    configuration.getFormat()));
        }
    }
//}
