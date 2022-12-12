package demo.builders;

import demo.LoggingLevel;
import demo.configurations.LoggerConfiguration;

public interface Builder {
    Builder setLevel(LoggingLevel level);

    Builder setFormat(String s);

    LoggerConfiguration build();

}
