package demo.interfaces;

import demo.LoggingLevel;

import java.io.File;

public abstract class LoggerConfiguration {

    public abstract void setThirdPosition(String message);

    public abstract File getFile();

    public abstract int getSize();

    public abstract String getDirPath();

    public abstract String getName();

    public abstract void setSecondPosition(String name);

    public abstract String getFirstPosition();

    public abstract String getSecondPosition();

    public abstract String getThirdPosition();

    public abstract void getLatestFileFromDir(String dirPath);

    public abstract LoggingLevel getLevel();
}

