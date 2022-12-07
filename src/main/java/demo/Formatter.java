package demo;

public class Formatter {

    public static String formatter(String one, String two, String three){
        return String.format("[%s][%s][%s]\n", one, two, three);
    }
}
