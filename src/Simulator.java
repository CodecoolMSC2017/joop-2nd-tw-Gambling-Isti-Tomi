package src;

public class Simulator {

    private Simulation simulation;
    private Logger logger;
    
    Simulator(Simulation simulation, Logger logger) {
        this.simulation = simulation;
        this.logger = logger;
    }

    Result run() {
        return new Result();
    }


}