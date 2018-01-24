package src;
import java.util.*;
import java.io.*;

public class Main {

    static String[] fileContent;
    static int amountOfRounds = 0;

    public static Simulation generateSimulation(int round, Cock[] cocks, boolean useData){
        Simulation simulation = new Simulation(round, cocks);
        Simulator simulator = new Simulator(simulation, new Logger(round, amountOfRounds));
        simulation.setResult(simulator.run(fileContent, useData));
        simulation.generateData("./data.csv");
        return simulation;
    }

    public static boolean getInfo(){
        Logger message = new Logger();
        Scanner input = new Scanner(System.in);
        message.simpleLog("", "Do you want to use the data.csv file? (Y/N)");
        while (true){   
            char answer = input.next().toLowerCase().charAt(0);
            if (answer == 'y'){
                return true;
            }
            else if (answer == 'n'){
                return false;
            }
            else {
                message.simpleLog("Error: ", "wrong input, try again!");
            }
        }
    }

    public static void main(String[] args){
        fileContent = getFileContent("./data.csv");
        try {
            amountOfRounds = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java src.Main [amount of simulations]\n" +
                "Note: number cannot be bigger than 1 000 000");
            System.exit(-1);
        }
        if (amountOfRounds > 1000000) {
            System.out.println("Number cannot be bigger than 1 000 000");
            System.exit(-1);
        }
        Simulation[] simulations = new Simulation[amountOfRounds];
        Cock[] cocks = generateCocks();

        Date now = new Date();
        now.getTime();
        boolean useData = getInfo();
        for (int round = 0; round < amountOfRounds; round++) {
            simulations[round] = generateSimulation(round, cocks, useData);
        }
        HashMap<String,Integer> victories = new HashMap<>();
        HashMap<String,Integer> fights = new HashMap<>();
        for (Cock cock : cocks){
            victories.put(cock.name, 0);
            fights.put(cock.name, 0);
            
        }
        for (Simulation simulation : simulations) {
            int victory = victories.get(simulation.getResult().winnerName);            
            victory++;           
            victories.put(simulation.getResult().winnerName, victory);            

            int allFight = fights.get(simulation.getResult().cock1Name);
            allFight++;
            fights.put(simulation.getResult().cock1Name, allFight);

            allFight = fights.get(simulation.getResult().cock2Name);
            allFight++;
            fights.put(simulation.getResult().cock2Name, allFight);



        }
        Logger log = new Logger();
        log.printStats(cocks, fights, victories, now);
        
    }

    private static Cock[] generateCocks() {
        final int amount = 8;
        Cock[] cocks = new Cock[amount];
        cocks[0] = new Cock("Mr. Sniffles", 2, 5, 34);
        cocks[1] = new Cock("Womb Raider", 1, 5, 37);
        cocks[2] = new Cock("Wedding Wrecker", 4, 4, 33);
        cocks[3] = new Cock("Clam Hammer", 3, 4, 35);
        cocks[4] = new Cock("Muff Marauder", 1, 1, 38);
        cocks[5] = new Cock("AIDS Baster", 5, 5, 24);
        cocks[6] = new Cock("Kidney Scraper", 3, 3, 30);
        cocks[7] = new Cock("Ho Wrecker", 1, 2, 35);
        return cocks;
    }

    private static int getFileLength(File file) {
        Scanner sc;
        int fileLength = 0;

        try {
            sc = new Scanner(file);

            while (sc.hasNext()) {
                fileLength++;
                sc.nextLine();
            }
            sc.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileLength;
    }

    private static String[] getFileContent(String fileName) {
        int fileLength = getFileLength(new File(fileName));
        String[] content = new String[fileLength];
        Scanner read;

        try {
            read = new Scanner(new File(fileName));
            int counter = 0;

            while (read.hasNext()) {
                content[counter] = read.nextLine();
                counter++;
            }
            read.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

}