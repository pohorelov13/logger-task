package demo;

import demo.configurations.LoggerConfiguration;
import demo.loaders.FileLoggerConfigurationLoader;
import demo.loggers.Logger;
import demo.loggers.FileLogger;

public class Main {

    public static void main(String[] args) {
      LoggerConfiguration logger = new FileLoggerConfigurationLoader()
              .load("C:\\Users\\Александр\\Documents\\Hillel\\Projects\\logger-task\\cofig.json");

//        FileLoggerConfiguration logger = new FileLoggerConfiguration.FileConfigurationBuilder()
//                .setLevel(LoggingLevel.INFO)
//                .setSize(100)
//                .setFormat("LEVEL-MESSAGE-TIME")
//                .setDir("C:\\\\Users\\\\Александр\\\\Documents\\\\Hillel\\\\Projects\\\\logger-task\\\\logs")
//                .build();

        Logger fileLogger = new FileLogger();
        fileLogger.doLogging(logger, "ALL");

    }}