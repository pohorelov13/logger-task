package demo;


import demo.interfaces.Logger2;
import demo.interfaces.LoggerConfiguration;

public class Main {

    public static void main(String[] args) {
//        LoggerConfiguration lc = new FileLoggerConfigurationLoader().load();
//        System.out.println(lc.getSize());
        LoggerConfiguration logger = new FileLoggerConfiguration.FileConfigurationBuilder()
                .setSize(100)
                .setThirdPosition("Test")
                .setDir("C:\\Users\\Александр\\Documents\\Lightshot\\loggs\\")
                .setLevel(LoggingLevel.INFO)
                .build();


        Logger2 fileLogger = new FileLogger();
        logger.getLatestFileFromDir(logger.getDirPath());
        fileLogger.logging(logger, "ALL");
    }
}
