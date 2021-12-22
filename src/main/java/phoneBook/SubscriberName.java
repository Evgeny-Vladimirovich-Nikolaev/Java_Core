import java.util.ArrayList;


public class SubscriberName {
    private static ArrayList<String> femaleFirstNames = getNamesList("femaleFirstNames.txt");
    private static ArrayList<String> femaleLastNames = getNamesList("femaleLastNames.txt");
    private static ArrayList<String> femalePatronymics = getNamesList("femalePatronymics.txt");
    private static ArrayList<String> maleFirstNames = getNamesList("maleFirstNames.txt");
    private static ArrayList<String> maleLastNames = getNamesList("maleLastNames.txt");
    private static ArrayList<String> malePatronymics = getNamesList("malePatronymics.txt");


    private static ArrayList<String> getNamesList(String fileName) {
        return ResourcesReader.readLines(fileName);
    }

}
