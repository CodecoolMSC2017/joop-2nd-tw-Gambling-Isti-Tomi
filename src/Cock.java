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

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if (!(obj instanceof Cock) || obj == null){
            return false;
        }
        Cock temp = (Cock)obj;
        if (this.name.equals(temp.name) && this.speed == temp.speed &&
            this.weight == temp.weight &&  this.height == temp.height) {
            return true;
        }
        return false;
    }
}