package src;

import java.util.Random;

public class Simulator {

    private Simulation simulation;
    private Logger logger;
    
    Simulator(Simulation simulation, Logger logger) {
        this.simulation = simulation;
        this.logger = logger;
    }

    public Result run() {
        Cock[] cocks = getRadomCocks(simulation.getCocks());



        Result result = new Result();

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
        return getWinner(cocks);
    }

}