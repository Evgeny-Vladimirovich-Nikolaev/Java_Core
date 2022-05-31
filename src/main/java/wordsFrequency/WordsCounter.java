package wordsFrequency;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordsCounter {

    public static void wordsCount(String text) {
        Map<String, Long> counts = Stream.of(text.toLowerCase())
                .map(t -> t.split("[ .,:;?!/\"]+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        counts.entrySet().forEach(System.out::println);
    }

}
