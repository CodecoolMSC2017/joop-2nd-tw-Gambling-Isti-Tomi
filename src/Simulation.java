package src;
import java.util.Random;

public class Simulation {

    private int id;
    private Result result;

    public Simulation(int round) {
        id = round;
    }

    public int getId() {
        return id;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

}