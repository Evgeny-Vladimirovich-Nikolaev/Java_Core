import java.util.ArrayList;
import java.util.List;

public class Experiment {

    private static List<List<Long>> allResults = new ArrayList<>();

    public static void main(String[] args) {
        allResults.add(HashCodeExperiment.getResults(3_000, 1000));
        allResults.add(HashCodeExperiment.getResults(6_000, 1000));
        allResults.add(HashCodeExperiment.getResults(12_000, 1000));
        allResults.add(HashCodeExperiment.getResults(24_000, 1000));

        for(List<Long> results : allResults) {
            System.out.println(results);
        }
    }

}

