package demo.interfaces;

public abstract class Logger2 {

    public abstract void info(LoggerConfiguration configuration, String message);
    public abstract void debug(LoggerConfiguration configuration, String message);
    public abstract void logging(LoggerConfiguration logger, String message);
}
