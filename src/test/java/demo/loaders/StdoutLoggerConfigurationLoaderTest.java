package demo.loaders;

import static org.junit.jupiter.api.Assertions.*;

import demo.log.LoggingLevel;
import demo.log.configurations.LoggerConfiguration;
import demo.log.loaders.StdoutLoggerConfigurationLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StdoutLoggerConfigurationLoaderTest {

    private static final String JSON_CONFIG_FILE = "src/main/resources/test/config.json";
    private static final String TEXT_CONFIG_FILE = "src/main/resources/test/config.txt";

    private StdoutLoggerConfigurationLoader loader;

    @BeforeEach
    public void setUp() {
        loader = new StdoutLoggerConfigurationLoader();
    }

    @Test
    public void testLoadJson() throws Exception {
        LoggerConfiguration config = loader.loadJson(JSON_CONFIG_FILE);
        assertNotNull(config);
        assertEquals(LoggingLevel.INFO, config.getLevel());
        assertEquals("TIME-MESSAGE-LEVEL", config.getFormat());
    }


    @Test
    public void testLoad() throws Exception {
        LoggerConfiguration config = loader.load(TEXT_CONFIG_FILE);
        assertNotNull(config);
        assertEquals(LoggingLevel.INFO, config.getLevel());
        assertEquals("Level-time-Message", config.getFormat());
    }

    @Test
    public void testLoadWithNonExistentFile() throws Exception {
        LoggerConfiguration config = loader.load("nonexistent.txt");
        assertNull(config);
    }
}