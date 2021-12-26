import java.util.*;
import java.util.stream.Collectors;


public class WordsCounter {

    public static void wordsCount(String text) {
        List<String> list = Arrays.asList(text.toLowerCase().split("[ ,.!/?;:]+"));
        Map<String, Integer> counts = list.stream()
                .collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
        counts.entrySet().forEach(System.out::println);
    }

}
