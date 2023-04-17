package demo.loggers;

import demo.log.LoggingLevel;
import demo.log.configurations.LoggerConfiguration;
import demo.log.loggers.StdoutLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StdoutLoggerTest {

    private LoggerConfiguration mockConfig;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalPrintStream;

    @BeforeEach
    void setUp() {
        mockConfig = mock(LoggerConfiguration.class);
        when(mockConfig.getFormat()).thenReturn("%s %s %s %s");
        when(mockConfig.getTime()).thenReturn("2022-04-17T12:00:00.000Z");
    }

    @Test
    void testDebugLogsWhenLevelIsDebug() {
        when(mockConfig.getLevel()).thenReturn(LoggingLevel.DEBUG);

        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        originalPrintStream = System.out;
        System.setOut(printStream);

        StdoutLogger logger = new StdoutLogger(mockConfig);
        logger.debug("debug message");

        assertEquals("[2022-04-17T12:00:00.000Z][DEBUG][debug message]\n", outputStream.toString());

        System.setOut(originalPrintStream);
    }

    @Test
    void testDebugDoesNotLogWhenLevelIsInfo() {
        when(mockConfig.getLevel()).thenReturn(LoggingLevel.INFO);

        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        originalPrintStream = System.out;
        System.setOut(printStream);

        StdoutLogger logger = new StdoutLogger(mockConfig);
        logger.debug("debug message");

        assertEquals("", outputStream.toString());

        System.setOut(originalPrintStream);
    }

    @Test
    void testInfoLogsWhenLevelIsDebug() {
        when(mockConfig.getLevel()).thenReturn(LoggingLevel.DEBUG);

        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        originalPrintStream = System.out;
        System.setOut(printStream);

        StdoutLogger logger = new StdoutLogger(mockConfig);
        logger.info("info message");

        assertEquals("[2022-04-17T12:00:00.000Z][INFO][info message]\n", outputStream.toString());

        System.setOut(originalPrintStream);
    }

    @Test
    void testInfoLogsWhenLevelIsInfo() {
        when(mockConfig.getLevel()).thenReturn(LoggingLevel.INFO);

        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        originalPrintStream = System.out;
        System.setOut(printStream);

        StdoutLogger logger = new StdoutLogger(mockConfig);
        logger.info("info message");

        assertEquals("[2022-04-17T12:00:00.000Z][INFO][info message]\n", outputStream.toString());

        System.setOut(originalPrintStream);
    }
}