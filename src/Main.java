package src;

public class Main {

    public static Simulation generateSimulation(int round){
        Simulation simulation = new Simulation();
        Simulator simulator = new Simulator(simulation, new Logger());
        simulation.setResult(simulator.run());
        return simulation;
    }

    public static void main(String[] args){
        int amountOfRounds = Integer.parseInt(args[0]);
        Simulation[] simulation = new Simulation[amountOfRounds];
        for (int round = 0; i < amountOfRounds; i++) {
            simulation[round] = generateSimulation(round);
        }
    }

}