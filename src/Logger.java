package src;
import java.util.Date;

public class Logger {
    static int counter = 1;

    public void log(String type, String message){
        Date now = new Date();
        now.getTime();
        System.out.format("\n%d.  %s %s %s\n",counter, now, type, message);
        counter++;
        
    }
}