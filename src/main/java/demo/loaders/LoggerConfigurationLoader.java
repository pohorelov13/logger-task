package demo.loaders;

import demo.configurations.LoggerConfiguration;

public abstract class LoggerConfigurationLoader {

    abstract LoggerConfiguration load(String path);
}
