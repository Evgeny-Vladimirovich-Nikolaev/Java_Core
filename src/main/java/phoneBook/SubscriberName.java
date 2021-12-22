import java.util.ArrayList;
import java.util.List;

public class SubscriberName {
    static {
        List<String> femaleFirstNames = getNames("femaleFirstNames.txt");
        List<String> femaleLastNames = getNames("femaleLastNames.txt");
        List<String> femalePatronymics = getNames("femalePatronymics.txt");
        List<String> maleFirstNames = getNames("maleFirstNames.txt");
        List<String> maleLastNames = getNames("maleLastNames.txt");
        List<String> malePatronymics = getNames("malePatronymics.txt");
    }

    private static List<String> getNames(String path) {
        ArrayList<String> s = new ArrayList<>();
        return s ;
    }

}
