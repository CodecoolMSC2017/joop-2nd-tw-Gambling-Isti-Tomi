package src;

public class Statistics {
    
    private static int amountOfSimulationRun;

    static int getAmountOfSimulationRun() {
        return amountOfSimulationRun;
    }

    static void addSimulation(Simulation simulation) {
        amountOfSimulationRun++;
    }

}