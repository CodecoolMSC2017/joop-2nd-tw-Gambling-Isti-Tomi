package src;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Simulation {
    private int id;
    private Cock[] cocks;
    private Result result;
    public static int roundCounter = 0;
    

    public Simulation(int round, Cock[] cocks) {
        this.id = round;
        this.cocks = cocks;
    }

    public void generateData(String filePath){
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file,true);
            if (roundCounter == 0){
                FileWriter clearFile = new FileWriter(file,false);
                clearFile.write("");
                roundCounter++;
            }
            BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);            
            fileWriter.append(result.toString());
            bufferFileWriter.close();
        }
        catch (IOException e){
            System.out.println("nem jo kocsog");
        }
    }

    public Simulation load(){
        return this;
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