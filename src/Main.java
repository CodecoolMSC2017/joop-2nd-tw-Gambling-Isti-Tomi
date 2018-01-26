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
        message.simpleLog("The program can either read the history from the file or run every single simulation again.\n", "Do you want to use the data.csv file to skip simulating? (Y/N)");
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
        try {
            amountOfRounds = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java src.Main [amount of simulations]\n" +
                "Note: number cannot be bigger than 1 000 000");
            System.exit(-1);
        } catch (NumberFormatException e) {
            System.out.println("Number cannot be bigger than 1 000 000");
            System.exit(-1);
        }
        if (amountOfRounds > 1000000) {
            System.out.println("Number cannot be bigger than 1 000 000");
            System.exit(-1);
        }
        Simulation[] simulations = new Simulation[amountOfRounds];
        Cock[] cocks = generateCocks();

        boolean useData = getInfo();
        Date now = new Date();
        now.getTime();
        if (useData) {
            fileContent = getFileContent("./data.csv");
            for (int round = 0; round < amountOfRounds; round++) {
                simulations[round] = generateSimulation(round, cocks, true);
            }
        } else {
            for (int round = 0; round < amountOfRounds; round++) {
                simulations[round] = generateSimulation(round, cocks, false);
            }
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
        final String FILE_COCK = "./source_data/cocks.csv";
        int amount = getFileLength(new File(FILE_COCK));
        String[] loadedCocks = getFileContent(FILE_COCK);
        Cock[] cocks = constructCocks(loadedCocks, amount);
        return cocks;
    }

    private static Cock[] constructCocks(String[] cocks, int amount){
        final int NAME = 0;
        final int SPEED = 1;
        final int WEIGTH = 2;
        final int HEIGTH = 3;
        Cock[] result = new Cock[amount];
        for (int i = 0; i < cocks.length; i++){
            String[] temp = cocks[i].split(",");
            result[i] = new Cock(temp[NAME], Integer.parseInt(temp[SPEED]),
                                 Integer.parseInt(temp[WEIGTH]), Integer.parseInt(temp[HEIGTH]));            
        }
        return result;
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