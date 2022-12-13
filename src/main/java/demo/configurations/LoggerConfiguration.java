package demo.configurations;

import demo.LoggingLevel;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class LoggerConfiguration {
    private LoggingLevel level = LoggingLevel.DEBUG;
    private String format = "TIME-LEVEL-MESSAGE";
    private final String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));


    public void setLevel(LoggingLevel level) {
        this.level = level;
    }


    public String getTime() {
        return time;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDirPath(){
        return null;
    }

    public File getFile(){
        return null;
    }

    public void setFile(File file){

    }

    public  String getLogName(){
        return null;
    }

    public int getSize(){
        return 0;
    }

}

