package demo;

import demo.interfaces.Logger2;
import demo.interfaces.LoggerConfiguration;

import java.io.*;


public class FileLogger extends Logger2 {

    public void logging(LoggerConfiguration configuration, String message) {
        switch (configuration.getLevel()) {
            case INFO -> info(configuration, message);
            case DEBUG -> debug(configuration, message);
        }
    }

    public void info(LoggerConfiguration configuration, String message) {
        configuration.setThirdPosition(message);
        configuration.setSecondPosition(configuration.getLevel().name());
        File file;
        if (configuration.getFile().length() < configuration.getSize()) {
            file = configuration.getFile();
        } else file = new File(configuration.getDirPath() + configuration.getName());
        try (FileOutputStream fos = new FileOutputStream(file, true);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write((Formatter.formatter(configuration.getFirstPosition(),
                    configuration.getSecondPosition(), configuration.getThirdPosition()).getBytes()));
            bos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void debug(LoggerConfiguration configuration, String message) {
        configuration.setThirdPosition(message);
        File file;
        if (configuration.getFile().length() < configuration.getSize()) {
            file = configuration.getFile();
        } else file = new File(configuration.getDirPath() + configuration.getName());
        try (FileOutputStream fos = new FileOutputStream(file, true);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            configuration.setSecondPosition(configuration.getLevel().name());
            bos.write((Formatter.formatter(configuration.getFirstPosition(),
                    configuration.getSecondPosition(), configuration.getThirdPosition()).getBytes()));
            bos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        info(configuration, message);
    }
}