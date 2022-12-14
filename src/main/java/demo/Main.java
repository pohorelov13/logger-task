package demo;

import demo.builders.FileLoggerConfigurationBuilder;
import demo.builders.StdoutLoggerConfigurationBuilder;
import demo.configurations.FileLoggerConfiguration;
import demo.configurations.LoggerConfiguration;
import demo.configurations.StdoutLoggerConfiguration;
import demo.loaders.FileLoggerConfigurationLoader;
import demo.loaders.StdoutLoggerConfigurationLoader;
import demo.loggers.FileLogger;
import demo.loggers.Logger;
import demo.loggers.StdoutLogger;

public class Main {

    public static void main(String[] args) {
        LoggerConfiguration configurationFile = new FileLoggerConfigurationLoader()
                .load("config.txt");

        LoggerConfiguration configurationBuild = new FileLoggerConfigurationBuilder()
                .setLevel(LoggingLevel.INFO)
                .setSize(100)
                .setFormat("LEVEL-TIME-MESSAGE")
                .setDir("LogsTEST")
                .build();

        Logger logger = new FileLogger(configurationFile);
        logger.debug("debug message");

        logger.info("info message");

    }
}