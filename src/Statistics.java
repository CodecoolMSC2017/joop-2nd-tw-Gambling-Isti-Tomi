package src;

public class Statistics extends Result {
    
    private static int amountOfSimulationRun;

    public Statistics(String cock1Name, int cock1Speed, int cock1Weight, int cock1Height,
        String cock2Name, int cock2Speed, int cock2Weight, int cock2Height, String winnerName) {
        super(cock1Name, cock1Speed, cock1Weight, cock1Height,
            cock2Name, cock2Speed, cock2Weight, cock2Height, winnerName);
    }

    static int getAmountOfSimulationRun() {
        return amountOfSimulationRun;
    }

    static void addSimulation(Simulation simulation) {
        amountOfSimulationRun++;
    }

}