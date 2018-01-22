package src;

public class Main {

public static Simulation generateSimulation(int round){
    Simulation simulation = new Simulation();
    simulation.testRandom();
    
    // for( int i = 0; i < round; i++){} // run simulation by times
    return simulation.load();    
}



    
public static void main(String[] args){
    Simulation randTest = Main.generateSimulation(Integer.parseInt(args[0]));
    Simulator tor = new Simulator(randTest, new Logger("test", "message"));
    }

}