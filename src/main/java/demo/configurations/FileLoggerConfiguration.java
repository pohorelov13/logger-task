package demo.configurations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration extends LoggerConfiguration {

    private int size = 30;

    private final String logName = String.format("\\Logs_%s.txt",
            LocalDateTime.now().format(DateTimeFormatter
            .ofPattern("dd.MM.yy_HH.mm.s")));

    private String dirPath = "Logs";

    public String getLogName() {
        return logName;
    }

    public String getDirPath() {
        return dirPath;
    }

    public int getSize() {
        return size;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    public void setSize(int size) {
        this.size = size;
    }

}