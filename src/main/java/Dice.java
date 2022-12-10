import java.util.Random;

public class Dice {
    int numOfDicePerRoll;
    int sides = 6;

    public Dice(int numOfDicePerRoll) {
        this.numOfDicePerRoll = numOfDicePerRoll;
    }

    public Integer tossAndSum() {
        Random rand = new Random();
        int sum = 0;
        for (int i = 0; i < numOfDicePerRoll; i++) {
            sum += (rand.nextInt(sides) + 1);
        }
        return sum;
//        return null;
    }
}
