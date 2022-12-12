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

    public File prepare(){
        return null;
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
}

