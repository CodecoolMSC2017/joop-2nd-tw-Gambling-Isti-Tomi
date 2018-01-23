package src;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    static int counter = 1;

    public Logger() {

    }

    public Logger(int round, int amountOfRounds) {
        double progress = Double.parseDouble(Integer.toString(round)) / Double.parseDouble(Integer.toString(amountOfRounds));
        try{
            System.out.println("\033[H\033[2JProgress: " + (int)(progress * 100) + "%");
        } catch(ArithmeticException e) {
            System.out.println("\033[H\033[2JProgress: 0%");
        }
    }

    public void log(String type, String message){
        Date now = new Date();
        now.getTime();
        System.out.format("\n%d.  %s\n %s %s\n",counter, now, type, message);
        counter++;
    }

    public void printStats(Cock[] cocks, HashMap fights, HashMap victories, Date begining) {
        System.out.println("\033[H\033[2JProgress: 100%");
        System.out.println("\nSimulation started: " + begining);
        Date now = new Date();
        now.getTime();
        System.out.println("Simulation ended  : " + now + "\n");
        for (Cock cock : cocks) {
            System.out.print(cock.name);
            System.out.print("\033[92m    fights: " + fights.get(cock.name));
            System.out.print("\033[93m    victories: " + victories.get(cock.name));
            double winRate = Double.parseDouble(victories.get(cock.name).toString()) / Double.parseDouble(fights.get(cock.name).toString());
            NumberFormat formatter = new DecimalFormat("#0.00");
            System.out.println("\033[96m    win rate: " + formatter.format(winRate * 100) + "%\033[0m");
        }
    }
}