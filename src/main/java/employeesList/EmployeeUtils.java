import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class EmployeeUtils {

    private ArrayList<Employee> employees;

    EmployeeUtils(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    void printAll() {
        Iterator<Employee> iterator = employees.iterator();
        System.out.println("\nОБЩИЙ СПИСОК СОТРУДНИКОВ:");
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            printFormatted(employee);
        }
    }

    void printWithWorkAge(int workAge) {
        Iterator<Employee> iterator = employees.iterator();
        System.out.printf("\nCПИСОК СОТРУДНИКОВ СО СТАЖЕМ %s ЛЕТ:\n", workAge);
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (countYears(employee) == workAge) {
                printFormatted(employee);
            }
        }
    }

    void printWithWorkAge(int workAge, boolean greater) {
        String gr;
        Iterator<Employee> iterator = employees.iterator();
        if(greater) {
            gr = " БОЛЬШЕ ";
        } else {
            gr = " МЕНЬШЕ ";
        }
        System.out.printf("\nCПИСОК СОТРУДНИКОВ СО СТАЖЕМ %s%s ЛЕТ:\n", gr, workAge);
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (greater && countYears(employee) > workAge
                || !greater && countYears(employee) < workAge) {
                printFormatted(employee);
            }
        }
    }

    void deleteByOddIndex() {
        ListIterator<Employee> listIterator = employees.listIterator(employees.size());
        while(listIterator.hasPrevious()) {
            int index = listIterator.previousIndex();
            listIterator.previous();
            if(index % 2 != 0) {
                listIterator.remove();
            }
        }
    }

    private void printFormatted(Employee employee) {
        System.out.println(
            employee
             + "\nСтаж работы: "
             + countYears(employee)
             + " лет");
    }

    private int countYears(Employee employee) {
        return Period.between(employee.getHireDate(), LocalDate.now()).getYears();
    }

}
