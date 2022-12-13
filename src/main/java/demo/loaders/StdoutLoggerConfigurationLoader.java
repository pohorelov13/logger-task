package demo.loaders;

import com.google.gson.Gson;
import demo.LoggingLevel;
import demo.configurations.FileLoggerConfiguration;
import demo.configurations.LoggerConfiguration;
import demo.configurations.StdoutLoggerConfiguration;

import java.io.*;

public class StdoutLoggerConfigurationLoader implements ConfigurationLoader {

    @Override
    public LoggerConfiguration loadJson(String pathname) {
        Gson gson = new Gson();
        File file = new File(pathname);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(br, StdoutLoggerConfiguration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LoggerConfiguration load(String pathname) {
        StdoutLoggerConfiguration configuration = new StdoutLoggerConfiguration();
        File file = new File(pathname);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
                String configParam = s.substring(s.lastIndexOf(':') + 1).trim();
                if (s.toLowerCase().startsWith("level:")) {
                    if (configParam.equals("info")) {
                        configuration.setLevel(LoggingLevel.INFO);
                    } else configuration.setLevel(LoggingLevel.DEBUG);
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
}
