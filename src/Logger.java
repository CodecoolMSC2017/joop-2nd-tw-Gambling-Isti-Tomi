package src;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    static int counter = 1;

    public void log(String type, String message){
        Date now = new Date();
        now.getTime();
        System.out.format("\n%d.  %s\n %s %s\n",counter, now, type, message);
        counter++;
    }

    public void printStats(Cock[] cocks, HashMap fights, HashMap victories) {
        for (Cock cock : cocks) {
            System.out.print(cock.name + " ");
            System.out.print("fights: " + fights.get(cock.name));
            System.out.println("  victories: " + victories.get(cock.name));
            

        }
    }
}