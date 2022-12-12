package demo.builders;

import demo.LoggingLevel;
import demo.configurations.FileLoggerConfiguration;

public class FileLoggerConfiguationBuilder implements Builder {
    FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration();

    @Override
    public Builder setFormat(String format) {
        fileLoggerConfiguration.setFormat(format);
        return this;
    }

    @Override
    public Builder setDir(String path) {
        fileLoggerConfiguration.setDirPath(path);
        return this;
    }

    @Override
    public Builder setLevel(LoggingLevel level) {
        fileLoggerConfiguration.setLevel(level);
        return this;
    }

    @Override
    public Builder setSize(int size) {
        fileLoggerConfiguration.size = size;
        return this;
    }

    @Override
    public FileLoggerConfiguration build() {
        return fileLoggerConfiguration;
    }
}
}
