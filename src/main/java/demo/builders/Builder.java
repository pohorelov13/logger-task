package demo.builders;

import demo.LoggingLevel;
import demo.configurations.LoggerConfiguration;

public interface Builder {
    Builder setDir (String s);
    Builder setLevel (LoggingLevel level);
    Builder setSize (int size);
    LoggerConfiguration build();

    Builder setFormat(String s);
}
