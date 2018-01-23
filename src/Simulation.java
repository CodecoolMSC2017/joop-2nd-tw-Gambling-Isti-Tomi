package src;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Simulation {
    private int id;
    private Cock[] cocks;
    private Result result;
    public static int roundCounter= 0;
    private static final int NAME = 0;
    private static final int SPEED = 1;
    private static final int WEIGTH = 2;
    private static final int HEIGTH = 3;
    private static final int STEP_TO_SECOND = 4;
    private static final int EXTEND_FOR_TWO = 2;
    private static final int FOR_FIRST_COCK_INDEX = 2;
    private static final int FOR_SECOND_COCK_INDEX = 1;
    Cock[] readedCocks = new Cock[0];

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

    public void makeCock(String[] read, int name, int speed, int weight, int height, int stepToSecond){
        cocks = Arrays.copyOf(cocks, cocks.length + 1);
                        cocks[cocks.length - 1] = new Cock(read[name],
                                          Integer.parseInt(read[speed]),
                                          Integer.parseInt(read[weight]),
                                          Integer.parseInt(read[height]));
    }

    public void load(){
        try{ 
            Scanner file = new Scanner(new File("./data.csv"));           
            while (file.hasNext()){
                String[] read = file.nextLine().split(";");
                if (Arrays.asList(readedCocks).contains(read[NAME]) &&
                    Arrays.asList(readedCocks).contains(read[NAME]) &&
                    readedCocks != null){                    
                        continue;
                    }
                    else if (Arrays.asList(readedCocks).contains(read[NAME])){ 
                        makeCock(read, NAME, SPEED, WEIGTH, HEIGTH, STEP_TO_SECOND);
                    }
                    else if (Arrays.asList(readedCocks).contains(read[NAME + STEP_TO_SECOND])){
                        makeCock(read, NAME, SPEED, WEIGTH, HEIGTH, 0);
                    }
                }             
            }        
        catch (IOException e){
            System.out.println("File not found when attempt to load");
        }
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