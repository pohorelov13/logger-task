package demo;

import demo.builders.FileLoggerConfigurationBuilder;
import demo.configurations.FileLoggerConfiguration;
import demo.configurations.LoggerConfiguration;
import demo.loaders.FileLoggerConfigurationLoader;
import demo.loggers.Logger;
import demo.loggers.FileLogger;

public class Main {

    public static void main(String[] args) {
      LoggerConfiguration configuration = new FileLoggerConfigurationLoader()
              .load("config.json");

//        LoggerConfiguration logger = new FileLoggerConfigurationBuilder()
//                .setLevel(LoggingLevel.DEBUG)
//                .setSize(100)
//                .setFormat("LEVEL-MESSAGE-TIME")
//                .setDir("TESTLog")
//                .build();

        Logger logger = new FileLogger();
        logger.doLogging(configuration, "TEST");

    }}