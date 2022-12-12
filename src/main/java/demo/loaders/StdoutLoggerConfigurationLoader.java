package demo.loaders;

import com.google.gson.Gson;
import demo.configurations.FileLoggerConfiguration;
import demo.configurations.LoggerConfiguration;
import demo.configurations.StdoutLoggerConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StdoutLoggerConfigurationLoader implements ConfigurationLoader{

    public LoggerConfiguration load(String pathname){
        Gson gson = new Gson();
        File file = new File(pathname);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return gson.fromJson(br, StdoutLoggerConfiguration.class);
    }
}
