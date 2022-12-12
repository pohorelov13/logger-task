package demo.loaders;

import com.google.gson.Gson;
import demo.configurations.FileLoggerConfiguration;
import demo.configurations.LoggerConfiguration;
import demo.configurations.StdoutLoggerConfiguration;

import java.io.*;

public class StdoutLoggerConfigurationLoader implements ConfigurationLoader{

    public LoggerConfiguration load(String pathname){
        Gson gson = new Gson();
        File file = new File(pathname);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(br, StdoutLoggerConfiguration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
