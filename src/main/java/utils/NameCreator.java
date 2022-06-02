package utils;

import java.util.ArrayList;
import java.util.Random;


public class NameCreator {
    private static final ArrayList<String> femaleLastNames = getNamesList("/femaleLastNames.txt");
    private static final ArrayList<String> femaleFirstNames = getNamesList("/femaleFirstNames.txt");
    private static final ArrayList<String> femalePatronymics = getNamesList("/femalePatronymics.txt");
    private static final ArrayList<String> maleLastNames = getNamesList("/maleLastNames.txt");
    private static final ArrayList<String> maleFirstNames = getNamesList("/maleFirstNames.txt");
    private static final ArrayList<String> malePatronymics = getNamesList("/malePatronymics.txt");

    public static String[] createFIO() {
        if(new Random().nextBoolean()) {
            return new String[]{
                    name(femaleLastNames),
                    name(femaleFirstNames),
                    name(femalePatronymics),
            };
        }
        return new String[]{
                name(maleLastNames),
                name(maleFirstNames),
                name(malePatronymics),
        };
    }

    private static ArrayList<String> getNamesList(String fileName) {
        return ResourcesReader.readByLines(fileName);
    }

    private static String name (ArrayList<String> names) {
        return names.get(new Random().nextInt(names.size()));
    }
}
