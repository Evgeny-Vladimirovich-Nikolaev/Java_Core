package wordsFrequency;

import utils.ResourcesReader;

public class WordsFrequency {

    public static void main(String[] args) {
        String text = ResourcesReader.readText("lorem.txt");
        WordsCounter.wordsCount(text);
        text = ResourcesReader.readText("povest.txt");
        WordsCounter.wordsCount(text);
    }
}
