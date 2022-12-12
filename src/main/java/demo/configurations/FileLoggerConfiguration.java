package demo.configurations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration extends LoggerConfiguration {

    private int size = 30;

    private final String logName = String.format("\\Logs_%s.txt", LocalDateTime.now().format(DateTimeFormatter
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

    public File prepare() {
        File file = null;
        try {
            if (getLatestFileFromDir(getDirPath()).length() < getSize()) {
                file = getLatestFileFromDir(getDirPath());
            } else file = new File(getDirPath() + getLogName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public File getLatestFileFromDir(String dirPath) throws IOException {
        File dir = new File(Files.createDirectories(Paths.get(getDirPath())).toString());//File(dirPath);
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
    }}