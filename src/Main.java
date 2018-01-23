package src;
import java.util.HashMap;

public class Main {

    public static Simulation generateSimulation(int round, Cock[] cocks){
        Simulation simulation = new Simulation(round, cocks);
        Simulator simulator = new Simulator(simulation, new Logger());
        simulation.setResult(simulator.run());
        return simulation;
    }

    public static void main(String[] args){
        int amountOfRounds = Integer.parseInt(args[0]);
        Simulation[] simulations = new Simulation[amountOfRounds];
        Cock[] cocks = generateCocks();
        for (int round = 0; round < amountOfRounds; round++) {
            simulations[round] = generateSimulation(round, cocks);
        }
        HashMap<String,Integer> victories = new HashMap<>();
        HashMap<String,Integer> fights = new HashMap<>();
        for (Cock cock : cocks){
            victories.put(cock.name, 0);
            fights.put(cock.name, 0);
            
        }
        for (Simulation simulation : simulations) {
            int victory = victories.get(simulation.getResult().winner.name);            
            victory++;           
            victories.put(simulation.getResult().winner.name, victory);            

            int allFight = fights.get(simulation.getResult().cock1Name);
            allFight++;
            fights.put(simulation.getResult().cock1Name, allFight);

            allFight = fights.get(simulation.getResult().cock2Name);
            allFight++;
            fights.put(simulation.getResult().cock2Name, allFight);



        }
        Logger log = new Logger();
        log.printVictories(cocks, victories);
    }

    private static Cock[] generateCocks() {
        final int amount = 5;
        Cock[] cocks = new Cock[amount];
        cocks[0] = new Cock("Mr. Sniffles", 2, 5, 37);
        cocks[1] = new Cock("Womb Raider", 1, 5, 37);
        cocks[2] = new Cock("Wedding Wrecker", 4, 4, 34);
        cocks[3] = new Cock("Clam Hammer", 3, 4, 35);
        cocks[4] = new Cock("Muff Marauder", 5, 3, 34);
        return cocks;
    }

}