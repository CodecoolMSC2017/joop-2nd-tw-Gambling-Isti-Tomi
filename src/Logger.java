package src;
import java.util.Date;


public class Logger {
    public static void log(String type, String message){
        Date now = new Date();
        now.getTime();
        System.out.format("\n%s %s %s\n", now, type, message);
        
    }
}