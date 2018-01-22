package src;
import java.util.Random;

public class Simulation {

    private int id;
    private Cock[] cocks;
    private Result result;

    public Simulation(int round, Cock[] cocks) {
        this.id = round;
        this.cocks = cocks;
    }

    public int getId() {
        return id;
    }

    public Cock[] getCocks() {
        return cocks;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

}