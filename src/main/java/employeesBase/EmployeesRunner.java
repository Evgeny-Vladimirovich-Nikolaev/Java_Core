import fileAccessor.FileResourcesUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class EmployeesRunner {

    public static void main(String[] args) {

        FileResourcesUtils resources;

        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> patronymics = new ArrayList<>();

        resources = new FileResourcesUtils("resources/lastNames.txt", lastNames);
        resources = new FileResourcesUtils("resources/firstNames.txt", firstNames);
        resources = new FileResourcesUtils("resources/patronymics.txt", patronymics);

        System.out.println(lastNames);
        System.out.println(firstNames);
        System.out.println(patronymics);



        //Date tenDaysAgo = new Date(new Date().getTime(); - aDay * 10);
        //System.out.println(new PeriodCounter().count());
    }

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}
