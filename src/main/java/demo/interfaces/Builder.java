package demo.interfaces;

import demo.FileLoggerConfiguration;
import demo.LoggingLevel;

public interface Builder {
    Builder setDir (String s);
    Builder setLevel (LoggingLevel level);
    Builder setSize (int size);
    Builder setFirstPosition(String position);
    Builder setSecondPosition(String position);
    Builder setThirdPosition(String position);
    FileLoggerConfiguration build();
}
