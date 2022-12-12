package demo.loggers;

import demo.LoggingLevel;
import demo.configurations.LoggerConfiguration;
import demo.utils.Formatter;

public class StdoutLogger extends Logger {
    @Override
    public void printLog(LoggerConfiguration configuration, String message) {
        System.out.print(Formatter.formatter(configuration.getTime(),
                configuration.getLevel().name(), message,
                configuration.getFormat()));
    }
}
