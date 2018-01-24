package src;

import java.util.Random;
import java.util.HashMap;

public class Simulator {

    private Simulation simulation;
    private Logger logger;
    private static HashMap<String, Integer> fights = new HashMap<>();
    
    Simulator(Simulation simulation, Logger logger) {
        this.simulation = simulation;
        this.logger = logger;
    }


    public Result run(String[] fileContent) {
        Cock[] cocks = getRadomCocks(simulation.getCocks());
        String[] sim = checkIfSimulationExists(fileContent, cocks);
        if (sim[0] != null) {
            String[] simu = sim[0].split(";");
            return new Statistics(simu[0], Integer.parseInt(simu[1]), Integer.parseInt(simu[2]), Integer.parseInt(simu[3]),
                simu[4], Integer.parseInt(simu[5]), Integer.parseInt(simu[6]), Integer.parseInt(simu[7]), simu[8]);
        }
        Cock winner = getWinner(cocks);

        Statistics stats = new Statistics(cocks[0].name, cocks[0].speed, cocks[0].weight, cocks[0].height, 
            cocks[1].name, cocks[1].speed, cocks[1].weight, cocks[1].height, winner.name);
        return stats;
    }

    private String[] checkIfSimulationExists(String[] fileContent, Cock[] cocks) {
        String[] result = new String[1];
        for (String line : fileContent) {
            String[] lineArray = line.split(";");
            if (lineArray[0].equals(cocks[0].name) || lineArray[4].equals(cocks[1].name)) {
                result[0] = line;
            }
            if (lineArray[0].equals(cocks[1].name) || lineArray[4].equals(cocks[0].name)) {
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
        int cock1Points = cocks[0].getTotalPoints();
        int cock2Points = cocks[1].getTotalPoints();
        cock1Points += new Random().nextInt(1);
        cock2Points += new Random().nextInt(1);

        if (cock1Points > cock2Points) {
            return cocks[0];
        }
        if (cock2Points > cock1Points) {
            return cocks[1];
        }
        return cocks[new Random().nextInt(1)];
    }

}