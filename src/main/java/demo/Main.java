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
//        LoggerConfiguration configuration = new FileLoggerConfigurationLoader()
//                .load("cofig.json");

        LoggerConfiguration configuration = new FileLoggerConfigurationBuilder()
                .setLevel(LoggingLevel.DEBUG)
                .setSize(100)
                .setFormat("LEVEL-TIME-MESSAGE")
                .setDir("LogsTEST")
                .build();

        Logger logger = new FileLogger();
        logger.doLogging(configuration, "TEST");

    }
}