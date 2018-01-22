package src;

public class Main {

public static Simulation generateSimulation(int round){
    Simulation simulation = new Simulation();
    // for( int i = 0; i < round; i++){} // run simulation by times
    return simulation;    
}



    
public static void main(String[] args){
    Main.generateSimulation(Integer.parseInt(args[0]));
    Logger.log("Test", "message");
    }

}