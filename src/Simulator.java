package src;

import java.util.Random;
import java.util.HashMap;
import java.util.Scanner;

public class Simulator {
    private static final int NAME = 0;
    private static final int SPEED = 1;
    private static final int WEIGTH = 2;
    private static final int HEIGTH = 3;
    private static final int STEP_TO_SECOND = 4;
    private static final int WINNER_NAME = 8;
    private static final int FIRST_COCK = 0;
    private static final int SECOND_COCK = 1;    
    private Simulation simulation;
    private Logger logger;
    private static HashMap<String, Integer> fights = new HashMap<>();
    
    
    Simulator(Simulation simulation, Logger logger) {
        this.simulation = simulation;
        this.logger = logger;
    }
    

    public Result run(String[] fileContent, boolean useData) {
        Cock[] cocks = getRadomCocks(simulation.getCocks());
        String[] sim = new String[1];

        if (sim[0] != null && useData) {
            String[] simu = sim[0].split(";");
            return new Statistics(simu[NAME], Integer.parseInt(simu[SPEED]), Integer.parseInt(simu[WEIGTH]), Integer.parseInt(simu[HEIGTH]),
                simu[NAME + STEP_TO_SECOND], Integer.parseInt(simu[SPEED + STEP_TO_SECOND]), Integer.parseInt(simu[WEIGTH + STEP_TO_SECOND]),
                Integer.parseInt(simu[HEIGTH + STEP_TO_SECOND]), simu[WINNER_NAME]);
        }
        Cock winner = getWinner(cocks);

        Statistics stats = new Statistics(cocks[FIRST_COCK].name, cocks[FIRST_COCK].speed, cocks[FIRST_COCK].weight, cocks[FIRST_COCK].height, 
            cocks[SECOND_COCK].name, cocks[SECOND_COCK].speed, cocks[SECOND_COCK].weight, cocks[SECOND_COCK].height, winner.name);
        return stats;
    }


    private String[] checkIfSimulationExists(String[] fileContent, Cock[] cocks) {
        String[] result = new String[1];
        for (String line : fileContent) {
            String[] lineArray = line.split(";");
            if (lineArray[NAME].equals(cocks[FIRST_COCK].name) && lineArray[NAME + STEP_TO_SECOND].equals(cocks[SECOND_COCK].name)) {
                result[0] = line;
            }
            if (lineArray[NAME].equals(cocks[SECOND_COCK].name) && lineArray[NAME + STEP_TO_SECOND].equals(cocks[FIRST_COCK].name)) {
                result[0] = line;
            }            
        }
        return result;
    }


    private Cock[] getRadomCocks(Cock[] cocks) {
        int rand1 = new Random().nextInt(cocks.length);
        int rand2;

        while (true) {
            rand2 = new Random().nextInt(cocks.length);
            if (rand1 != rand2) {
                break;
            }
        }
        return new Cock[] {cocks[rand1], cocks[rand2]};
    }


    private Cock getWinner(Cock[] cocks) {
        int cock1Points = cocks[FIRST_COCK].getTotalPoints();
        int cock2Points = cocks[SECOND_COCK].getTotalPoints();
        cock1Points += new Random().nextInt(1);
        cock2Points += new Random().nextInt(1);

        if (cock1Points > cock2Points) {
            return cocks[FIRST_COCK];
        }
        if (cock2Points > cock1Points) {
            return cocks[SECOND_COCK];
        }
        return cocks[new Random().nextInt(1)];
    }
}