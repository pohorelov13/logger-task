package demo.mathLib;

import demo.log.configurations.FileLoggerConfiguration;
import demo.log.loggers.FileLogger;

public class SimpleMathLibrary {
    private final FileLogger logger = new FileLogger(new FileLoggerConfiguration());

    public double add(double a, double b) {
        logger.info("CALL METHOD ADD");
        return a + b;
    }

    public double minus(double a, double b) {
        logger.info("CALL METHOD MINUS");
        return a - b;
    }

    public double multiply(double a, double b) {
        logger.info("CALL METHOD MULTIPLY");
        return a * b;
    }

    public double divide(double a, double b) {
        logger.info("CALL METHOD DIVIDE");
        if (b != 0) {
            return a / b;
        } else {
            logger.debug("DIVIDE BY ZERO IN METHOD DIVIDE");
            throw new RuntimeException("ATTEMPT TO DIVIDE BY ZERO");
        }
    }
}
