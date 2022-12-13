package demo.configurations;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration extends LoggerConfiguration {

    private int size = 30;

    private final String logName = String.format("\\Logs_%s.txt", LocalDateTime.now().format(DateTimeFormatter
            .ofPattern("dd.MM.yy_HH.mm.s")));

    private String dirPath = "Logs";
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

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