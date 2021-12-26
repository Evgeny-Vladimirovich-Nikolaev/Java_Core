import java.util.ArrayList;
import java.util.Arrays;

public class WordsFrequency {

    public static void main(String[] args) {
        ArrayList<String> text = ResourcesReader.readByLines("lorem.txt");
        System.out.println(text);

    }
}
