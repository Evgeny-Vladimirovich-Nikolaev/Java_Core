package employeesList;

import utils.RandomDate;
import utils.ResourcesReader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class EmployeesList{

    private static int id = 0;
    private ArrayList<String> lastNames = new ArrayList<>();
    private ArrayList<String> firstNames = new ArrayList<>();
    private ArrayList<String> patronymics = new ArrayList<>();

    public ArrayList<SimpleEmployee> create() {
        ArrayList<SimpleEmployee> list = new ArrayList<>(100);
        fillArrays();
        for (int i = 0; i < 100; i++) {
            list.add(createRecord());
        }
        return list;
    }

    private void fillArrays() {
        lastNames = ResourcesReader.readByLines("/maleLastNames.txt");
        firstNames = ResourcesReader.readByLines("/maleFirstNames.txt");
        patronymics = ResourcesReader.readByLines("/malePatronymics.txt");
    }

    private SimpleEmployee createRecord() {
        Random random = new Random();
        String lastName = lastNames.get(random.nextInt(lastNames.size()));
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String patronymic = patronymics.get(random.nextInt(patronymics.size()));
        LocalDate hireDate = RandomDate.getJavaEpochDate();
        return new SimpleEmployee(++id, lastName, firstName, patronymic, hireDate);
    }

}
