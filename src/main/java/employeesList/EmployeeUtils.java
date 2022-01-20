import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class EmployeeUtils {

    private ArrayList<SimpleEmployee> simpleEmployees;

    EmployeeUtils(ArrayList<SimpleEmployee> simpleEmployees) {
        this.simpleEmployees = simpleEmployees;
    }

    void printAll() {
        Iterator<SimpleEmployee> iterator = simpleEmployees.iterator();
        System.out.println("\nОБЩИЙ СПИСОК СОТРУДНИКОВ:");
        while (iterator.hasNext()) {
            SimpleEmployee simpleEmployee = iterator.next();
            printFormatted(simpleEmployee);
        }
    }

    void printWithWorkAge(int workAge) {
        Iterator<SimpleEmployee> iterator = simpleEmployees.iterator();
        System.out.printf("\nCПИСОК СОТРУДНИКОВ СО СТАЖЕМ %s ЛЕТ:\n", workAge);
        while (iterator.hasNext()) {
            SimpleEmployee simpleEmployee = iterator.next();
            if (countYears(simpleEmployee) == workAge) {
                printFormatted(simpleEmployee);
            }
        }
    }

    void printWithWorkAge(int workAge, boolean greater) {
        String gr;
        Iterator<SimpleEmployee> iterator = simpleEmployees.iterator();
        if(greater) {
            gr = " БОЛЬШЕ ";
        } else {
            gr = " МЕНЬШЕ ";
        }
        System.out.printf("\nCПИСОК СОТРУДНИКОВ СО СТАЖЕМ %s%s ЛЕТ:\n", gr, workAge);
        while (iterator.hasNext()) {
            SimpleEmployee simpleEmployee = iterator.next();
            if (greater && countYears(simpleEmployee) > workAge
                || !greater && countYears(simpleEmployee) < workAge) {
                printFormatted(simpleEmployee);
            }
        }
    }

    void deleteByOddIndex() {
        ListIterator<SimpleEmployee> listIterator = simpleEmployees.listIterator(simpleEmployees.size());
        while(listIterator.hasPrevious()) {
            int index = listIterator.previousIndex();
            listIterator.previous();
            if(index % 2 != 0) {
                listIterator.remove();
            }
        }
    }

    private void printFormatted(SimpleEmployee simpleEmployee) {
        System.out.println(
            simpleEmployee
             + "\nСтаж работы: "
             + countYears(simpleEmployee)
             + " лет");
    }

    private int countYears(SimpleEmployee simpleEmployee) {
        return Period.between(simpleEmployee.getHireDate(), LocalDate.now()).getYears();
    }

}
