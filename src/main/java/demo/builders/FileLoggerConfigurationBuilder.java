package demo.builders;

import demo.LoggingLevel;
import demo.configurations.FileLoggerConfiguration;
import demo.configurations.LoggerConfiguration;

public class FileLoggerConfigurationBuilder implements Builder {

    FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration();

    @Override
    public FileLoggerConfigurationBuilder setFormat(String format) {
        fileLoggerConfiguration.setFormat(format);
        return this;
    }

    public FileLoggerConfigurationBuilder setDir(String path) {
        fileLoggerConfiguration.setDirPath(path);
        return this;
    }

    @Override
    public FileLoggerConfigurationBuilder setLevel(LoggingLevel level) {
        fileLoggerConfiguration.setLevel(level);
        return this;
    }

    public FileLoggerConfigurationBuilder setSize(int size) {
        fileLoggerConfiguration.setSize(size);
        return this;
    }

    @Override
    public LoggerConfiguration build() {
        return fileLoggerConfiguration;
    }
}
