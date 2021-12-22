import java.util.ArrayList;
import java.util.List;

public class SubscriberName {
    static {
        List<String> femaleFirstNames = getNames("resources/femaleFirstNames.txt");
        List<String> femaleLastNames = getNames("resources/femaleLastNames.txt");
        List<String> femalePatronymics = getNames("resources/femalePatronymics.txt");
        List<String> maleFirstNames = getNames("resources/maleFirstNames.txt");
        List<String> maleLastNames = getNames("resources/maleLastNames.txt");
        List<String> malePatronymics = getNames("resources/malePatronymics.txt");
    }

    private static List<String> getNames(String path) {
        ArrayList<String> s = new ArrayList<>();
        return s ;
    }

}
