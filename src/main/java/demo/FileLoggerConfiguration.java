package demo;

import demo.interfaces.Builder;
import demo.interfaces.LoggerConfiguration;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration extends LoggerConfiguration {
    public LoggingLevel getLevel() {
        return level;
    }

    private LoggingLevel level = LoggingLevel.DEBUG;

    private File file;
    private int size = 30;
    private String firstPosition = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    private String secondPosition = getLevel().name();
    private String thirdPosition = "Default message";
    private String name = String.format("\\Log_%s.txt", LocalDateTime.now().format(DateTimeFormatter
            .ofPattern("dd.MM.yy-HH_mm_s")));
    private String dirPath = "C:\\Users\\Александр\\Documents\\Lightshot\\loggs\\";


    public void setThirdPosition(String thirdPosition) {
        this.thirdPosition = thirdPosition;
    }

    public String getFirstPosition() {
        return firstPosition;
    }

    public String getSecondPosition() {
        return secondPosition;
    }

    public String getThirdPosition() {
        return thirdPosition;
    }

    public String getName() {
        return name;
    }

    public String getDirPath() {
        return dirPath;
    }

    public File getFile() {
        return file;
    }

    public int getSize() {
        return size;
    }

    public void setSecondPosition(String secondPosition) {
        this.secondPosition = secondPosition;
    }

    static class FileConfigurationBuilder implements Builder {

        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration();

        @Override
        public Builder setDir(String s) {
            fileLoggerConfiguration.dirPath = s;
            return this;
        }

        @Override
        public Builder setLevel(LoggingLevel level) {
            fileLoggerConfiguration.level = level;
            return this;
        }

        @Override
        public Builder setSize(int size) {
            fileLoggerConfiguration.size = size;
            return this;
        }

        @Override
        public Builder setFirstPosition(String position) {
            fileLoggerConfiguration.firstPosition = position;
            return this;
        }

        @Override
        public Builder setSecondPosition(String position) {
            fileLoggerConfiguration.secondPosition = position;
            return this;
        }

        @Override
        public Builder setThirdPosition(String position) {
            fileLoggerConfiguration.thirdPosition = position;
            return this;
        }

        public FileLoggerConfiguration build() {
            return fileLoggerConfiguration;
        }
    }

   public void getLatestFileFromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
           this.file = new File(dirPath + name);
        } else {
            File lastModifiedFile = files[0];
            for (int i = 1; i < files.length; i++) {
                if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                    lastModifiedFile = files[i];
                }
            }
            System.out.println(lastModifiedFile);
            this. file = lastModifiedFile;
        }
    }
}