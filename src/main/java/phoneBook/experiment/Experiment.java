import java.util.ArrayList;
import java.util.List;

public class Experiment {

    private static List<List<Long>> allResults = new ArrayList<>();

    public static void main(String[] args) {
        allResults.add(HashCodeExperiment.getResults(10_000, 5000));
        allResults.add(HashCodeExperiment.getResults(10_000, 5000));
        allResults.add(HashCodeExperiment.getResults(10_000, 5000));
        allResults.add(HashCodeExperiment.getResults(10_000, 5000));

        for(List<Long> results : allResults) {
            System.out.println(results);
        }
    }

}

