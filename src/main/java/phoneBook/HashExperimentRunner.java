package phoneBook;

import phoneBook.experiment.HashCodeExperiment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class HashExperimentRunner {

    private static final int SUBSCRIBERS = 10_000;
    private static final int REQUESTS = 5_000;
    private static final int ITERATIONS = 10;

    private static final double[] avgResults = new double[8];

    public static void main(String[] args) {
        for (int i = 0; i < ITERATIONS; i++) start();
        roundDouble(1);
        printReport();
    }

    private static void start() {
        List<Long> results = new ArrayList<>(HashCodeExperiment.getResults(SUBSCRIBERS, REQUESTS));
        for (int i = 0; i < 8; i++) {
            if (results.get(i) != 0) avgResults[i] += (double) results.get(i) / 10;
        }
    }

    private static void roundDouble(int places) {
        if (places < 0) throw new IllegalArgumentException();
        for (int i = 0; i < 8; i++) {
            BigDecimal bd = new BigDecimal(Double.toString(avgResults[i]));
            bd = bd.setScale(places, RoundingMode.HALF_UP);
            avgResults[i] = bd.doubleValue();
        }
    }

    private static void printReport() {
        System.out.println("//////////////////////////////////////////////////////");
        print("РАЗНЫМ", 0);
        print("РАВНЫМ", 4);
    }

    private static void print(String hashType, int ind) {

        StringBuilder sb = new StringBuilder
                ("------------------------------------------------------\n");
        sb.append("СРЕДНЕЕ ВРЕМЯ ПОИСКА С ");
        sb.append(hashType);
        sb.append(" ХЭШКОДОМ (контактов ");
        sb.append(SUBSCRIBERS);
        sb.append(", запросов ");
        sb.append(REQUESTS);
        sb.append(", запусков ");
        sb.append(ITERATIONS);
        sb.append("):\nКарта по значению: ");
        sb.append(avgResults[ind++]);
        sb.append("\nСписок: ");
        sb.append(avgResults[ind++]);
        sb.append("\nХэш-сет: ");
        sb.append(avgResults[ind++]);
        sb.append("\nКарта по ключу: ");
        sb.append(avgResults[ind]);
        System.out.println(sb);
    }

}

