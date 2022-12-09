package demo.interfaces;

import demo.configurations.FileLoggerConfiguration;
import demo.LoggingLevel;

public interface Builder {
    Builder setDir (String s);
    Builder setLevel (LoggingLevel level);
    Builder setSize (int size);
    FileLoggerConfiguration build();

    Builder setFormat(String s);
}
