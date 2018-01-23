package src;

public class Cock{
    String name;
    int speed;
    int weight;
    int height;

    public Cock(String name, int speed, int weight, int height){
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.height = height;
    }

    public int getTotalPoints() {
        return speed * 2 + weight + height;
    }
}