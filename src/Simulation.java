package src;
import java.util.Random;

public class Simulation {

    private Result result;
    private int rndInt;

    public int testRandom(){
        Random rnd = new Random();
        rndInt = rnd.nextInt(50);
        return rndInt;
    }

    public int load(){
        return rndInt;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

}