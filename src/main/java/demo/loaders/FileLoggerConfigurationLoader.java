package demo.loaders;

import com.google.gson.Gson;
import demo.configurations.FileLoggerConfiguration;
import demo.configurations.LoggerConfiguration;

import java.io.*;

public class FileLoggerConfigurationLoader {

    public LoggerConfiguration load(String pathname) {
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
