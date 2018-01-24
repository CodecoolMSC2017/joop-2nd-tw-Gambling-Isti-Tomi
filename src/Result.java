package src;

public class Result {

    String cock1Name;
    int cock1Speed;
    int cock1Weight;
    int cock1Height;
    String cock2Name;
    int cock2Speed;
    int cock2Weight;
    int cock2Height;
    String winnerName;

    public Result(String cock1Name, int cock1Speed, int cock1Weight, int cock1Height,
        String cock2Name, int cock2Speed, int cock2Weight, int cock2Height, String winnerName) {
        this.cock1Name = cock1Name;
        this.cock1Speed = cock1Speed;
        this.cock1Weight = cock1Weight;
        this.cock1Height= cock1Height;
        this.cock2Name = cock2Name;
        this.cock2Speed= cock2Speed;
        this.cock2Weight = cock2Weight;
        this.cock2Height = cock2Height;
        this.winnerName = winnerName;
    }

    @Override
    public String toString() {
        return cock1Name + ";" + cock1Speed + ";" + cock1Weight + ";" + cock1Height + ";" +
        cock2Name + ";" + cock2Speed + ";" + cock2Weight + ";" + cock2Height + ";" + winnerName + "\n";
    }

}