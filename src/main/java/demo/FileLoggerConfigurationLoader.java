package demo;

import com.google.gson.Gson;
import demo.interfaces.LoggerConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileLoggerConfigurationLoader {

    LoggerConfiguration load(){
        Gson gson = new Gson();
        File file = new File("C:\\Users\\Александр\\Documents\\Hillel\\Projects\\logger-task\\cofig.json");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return gson.fromJson(br, FileLoggerConfiguration.class);
    }
}
