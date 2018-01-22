package src;

public class Cock{
    String name;
    int speed;
    int weigth;
    int height;

    public Cock(String name, int speed, int weigth, int height){
        this.name = name;
        this.speed = speed;
        this.weigth = weigth;
        this.height = height;
    }

    public int getTotalPoints() {
        return speed + weigth + height;
    }
}