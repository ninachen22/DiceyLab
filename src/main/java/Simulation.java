public class Simulation {
    private final int numOfRolls;
    private final int numOfDicePerRoll;
    Integer maxSum;
    Integer lowSum;
    Bins bins;

    public static void main(String[] args) {
        int numOfRolls = 1000000;
        int numOfDicePerRoll = 2;

        Simulation sim = new Simulation(numOfRolls, numOfDicePerRoll);
        sim.run();
        sim.printResults();

    }

    private void printResults() {
        System.out.println("");
        for (int i = numOfDicePerRoll; i <= maxSum; i++) {
//            System.out.printf("%2s | %10s | %n", i, bins.getSpecificBinCount(i).toString());
            System.out.printf("%2s | %10s | %.2f | %2s %n", i,
                    bins.getSpecificBinCount(i).toString(), bins.percentOfEachResult(i), displayStars(i));
        }
    }

    public String displayStars(int resultSum) {
        String stars = "";
        for (int i = 0; i < Math.round(bins.percentOfEachResult(resultSum) * 100); i++) {
            stars += "*";
        }
        return stars;
    }

    public Simulation(int numOfRolls, int numOfDicePerRoll) {
        this.numOfRolls = numOfRolls;
        this.numOfDicePerRoll = numOfDicePerRoll;

        maxSum = numOfDicePerRoll * 6;
        lowSum = numOfDicePerRoll;
        bins = new Bins(lowSum, maxSum);
    }

    public void run() {
        Dice dice = new Dice(numOfDicePerRoll);
        for (int i = 0; i < numOfRolls; i++) {
            int sum = dice.tossAndSum();
            bins.incrementResult(sum);
        }

    }


}
