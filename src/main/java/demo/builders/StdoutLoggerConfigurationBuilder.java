package demo.builders;

import demo.LoggingLevel;
import demo.configurations.LoggerConfiguration;
import demo.configurations.StdoutLoggerConfiguration;

public class StdoutLoggerConfigurationBuilder implements Builder {
    StdoutLoggerConfiguration stdoutLoggerConfiguration = new StdoutLoggerConfiguration();

    @Override
    public StdoutLoggerConfigurationBuilder setFormat(String format) {
        stdoutLoggerConfiguration.setFormat(format);
        return this;
    }


    @Override
    public StdoutLoggerConfigurationBuilder setLevel(LoggingLevel level) {
        stdoutLoggerConfiguration.setLevel(level);
        return this;
    }

    @Override
    public LoggerConfiguration build() {
        return stdoutLoggerConfiguration;
    }
}
