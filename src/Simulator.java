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


    public Result run() {
        Cock[] cocks = getRadomCocks(simulation.getCocks());
        Cock winner = getWinner(cocks);
        logger.log("fight over:", cocks[0].name + " vs " + cocks[1].name + ", winner: " + winner.name); // for testing

        Statistics stats = new Statistics(cocks[0].name, cocks[0].speed, cocks[0].weight, cocks[0].height, 
            cocks[1].name, cocks[1].speed, cocks[1].weight, cocks[1].height, winner);
        return stats;
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