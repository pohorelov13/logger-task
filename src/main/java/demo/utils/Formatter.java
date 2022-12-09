package demo.utils;

public class Formatter {

    public static String formatter(String time, String level, String message, String format) {
        return switch (format.toLowerCase()) {
            case "level-time-message" -> String.format("[%s][%s][%s]\n", level, time, message);
            case "message-time-level" -> String.format("[%s][%s][%s]\n", message, time, level);
            case "time-message-level" -> String.format("[%s][%s][%s]\n", time, message, level);
            case "level-message-time" -> String.format("[%s][%s][%s]\n", level, message, time);
            case "message-level-time" -> String.format("[%s][%s][%s]\n", message, level, time);
            default -> String.format("[%s][%s][%s]\n", time, level, message);
        };

    }
}
