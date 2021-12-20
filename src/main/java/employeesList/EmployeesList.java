import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EmployeesList {

    private static int id = 0;
    private ArrayList<String> lastNames = new ArrayList<>();
    private ArrayList<String> firstNames = new ArrayList<>();
    private ArrayList<String> patronymics = new ArrayList<>();

     public ArrayList<Employee> create(){
        ArrayList<Employee> list = new ArrayList<>(100);
        fillArrays();
        for(int i = 0; i < 100; i++) {
            list.add(createRecord());
        }
        return list;
    }

    private void fillArrays() {
        new FileResourcesUtils("resources/lastNames.txt", lastNames);
        new FileResourcesUtils("resources/firstNames.txt", firstNames);
        new FileResourcesUtils("resources/patronymics.txt", patronymics);
    }

    private Employee createRecord() {
        Random random = new Random();
        String lastName = lastNames.get(random.nextInt(lastNames.size()));
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String patronymic = patronymics.get(random.nextInt(patronymics.size()));
        LocalDate hireDate = randomDate();
        return new Employee(++id, lastName, firstName, patronymic, hireDate);
    }

    private static LocalDate randomDate() {
        long startEpochDay = LocalDate.EPOCH.toEpochDay();
        long endEpochDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}
