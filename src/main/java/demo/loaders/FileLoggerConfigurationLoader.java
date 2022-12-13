package demo.loaders;

import com.google.gson.Gson;
import demo.LoggingLevel;
import demo.configurations.FileLoggerConfiguration;
import demo.configurations.LoggerConfiguration;

import java.io.*;

public class FileLoggerConfigurationLoader implements ConfigurationLoader {

    @Override
    public LoggerConfiguration load(String pathname) {
        FileLoggerConfiguration configuration = new FileLoggerConfiguration();
        File file = new File(pathname);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
                String configParam = s.substring(s.lastIndexOf(':') + 1).trim();
                if (s.toLowerCase().startsWith("file:")) {
                    configuration.setDirPath(configParam);
                } else if (s.toLowerCase().startsWith("level:")) {
                    if (configParam.equals("info")) {
                        configuration.setLevel(LoggingLevel.INFO);
                    } else configuration.setLevel(LoggingLevel.DEBUG);
                } else if (s.toLowerCase().startsWith("max-size:")) {
                    configuration.setSize(Integer.parseInt(configParam));
                } else if (s.toLowerCase().startsWith("format:")) {
                    configuration.setFormat(configParam.trim());
                }
            }
            return configuration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LoggerConfiguration loadJson(String pathname) {
        Gson gson = new Gson();
        File file = new File(pathname);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(br, FileLoggerConfiguration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
