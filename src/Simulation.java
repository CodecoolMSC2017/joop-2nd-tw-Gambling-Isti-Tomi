package src;
import java.util.Random;
import java.io.*;

public class Simulation {
    private int id;
    private Cock[] cocks;
    private Result result;

    public Simulation(int round, Cock[] cocks) {
        this.id = round;
        this.cocks = cocks;
    }

    public void generateData(String filePath){
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);
        fileWriter.append(result.toSting());
        file.close();
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