import java.util.Map;
import java.util.stream.Stream;

public class WordsCounter {


    private WordsCounter() {}

    public static void wordsCount(String text) {
        Map<String, Integer> words = (Map<String, Integer>) Stream.of(text);
    }
}
