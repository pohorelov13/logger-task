package demo.configurations;

import demo.LoggingLevel;
import demo.interfaces.Builder;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration extends LoggerConfiguration {

    private int size = 30;

    private final String logName = String.format("\\Log_%s.txt", LocalDateTime.now().format(DateTimeFormatter
            .ofPattern("dd.MM.yy-HH_mm_s")));

    private String dirPath = "C:\\Users\\Александр\\Documents\\Lightshot\\loggs\\";

    public String getLogName() {
        return logName;
    }

    public String getDirPath() {
        return dirPath;
    }

    public int getSize() {
        return size;
    }

    public File prepare() {
        File file;
        if (getLatestFileFromDir(getDirPath()).length() < getSize()) {
            file = getLatestFileFromDir(getDirPath());
        } else file = new File(getDirPath() + getLogName());
        return file;
    }

    public File getLatestFileFromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return new File(dirPath + getLogName());
        } else {
            File lastModifiedFile = files[0];
            for (int i = 1; i < files.length; i++) {
                if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                    lastModifiedFile = files[i];
                }
            }
            return lastModifiedFile;
        }
    }

   public static class FileConfigurationBuilder implements Builder {

        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration();

        @Override
        public Builder setFormat(String format) {
            fileLoggerConfiguration.setFormat(format);
            return this;
        }

        @Override
        public Builder setDir(String path) {
            fileLoggerConfiguration.dirPath = path;
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