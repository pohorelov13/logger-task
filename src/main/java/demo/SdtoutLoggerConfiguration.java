package demo;

import demo.interfaces.LoggerConfiguration;

import java.io.File;

public class SdtoutLoggerConfiguration extends LoggerConfiguration {

    private LoggingLevel level = LoggingLevel.DEBUG;
    private File file;
    private int size = 30;
    private String name;
    @Override
    public void setThirdPosition(String message) {

    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getDirPath() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setSecondPosition(String name) {

    }

    @Override
    public String getFirstPosition() {
        return null;
    }

    @Override
    public String getSecondPosition() {
        return null;
    }

    @Override
    public String getThirdPosition() {
        return null;
    }

    @Override
    public void getLatestFileFromDir(String dirPath) {

    }

    @Override
    public LoggingLevel getLevel() {
        return null;
    }
}
