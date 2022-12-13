package demo.loaders;

import demo.configurations.LoggerConfiguration;

public interface ConfigurationLoader {
    LoggerConfiguration load(String pathname);
    LoggerConfiguration loadJson(String pathname);
}
