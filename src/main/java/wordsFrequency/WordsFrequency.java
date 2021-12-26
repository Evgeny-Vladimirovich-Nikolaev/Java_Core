public class WordsFrequency {

    public static void main(String[] args) {
        String text = ResourcesReader.readText("povest.txt");
        System.out.println(text);
       WordsCounter.wordsCount(text);

    }
}
