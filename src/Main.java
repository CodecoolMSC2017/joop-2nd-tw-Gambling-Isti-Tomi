package src;

public class Main {

    public static Simulation generateSimulation(int round){
        Simulation simulation = new Simulation(round);
        Simulator simulator = new Simulator(simulation, new Logger());
        simulation.setResult(simulator.run());
        return simulation;
    }

    public static void main(String[] args){
        int amountOfRounds = Integer.parseInt(args[0]);
        Simulation[] simulation = new Simulation[amountOfRounds];
        for (int round = 0; round < amountOfRounds; round++) {
            simulation[round] = generateSimulation(round);
        }
    }

}