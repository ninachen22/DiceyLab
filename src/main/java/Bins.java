import java.util.TreeMap;

public class Bins {
    TreeMap<Integer, Integer> binsResultsTracker;
    private Integer totalRolls = 0;

    public Bins(int lowSum, int maxSum) {
        this.binsResultsTracker = new TreeMap<Integer, Integer>();

        for (int i = lowSum; i <= maxSum; i++) {
            binsResultsTracker.put(i, 0);
        }
    }

    public void incrementResult(int rollResult) {
        binsResultsTracker.put(rollResult, binsResultsTracker.get(rollResult) + 1);
        totalRolls++;
    }

    public Integer getSpecificBinCount(int specificBin) {
        return binsResultsTracker.get(specificBin);
    }

}
