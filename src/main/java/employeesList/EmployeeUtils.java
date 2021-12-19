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

    void getAll() {
        Iterator<Employee> iterator = employees.iterator();
        System.out.println("\nОБЩИЙ СПИСОК СОТРУДНИКОВ:");
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            format(employee);
        }
    }

    void getWithWorkAge(int workAge) {
        Iterator<Employee> iterator = employees.iterator();
        System.out.printf("\nCПИСОК СОТРУДНИКОВ СО СТАЖЕМ %s ЛЕТ:\n", workAge);
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (getYears(employee) == workAge) {
                format(employee);
            }
        }
    }

    void getWithWorkAge(int workAge, boolean greater) {
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
            if (greater && getYears(employee) > workAge
                || !greater && getYears(employee) < workAge) {
                format(employee);
            }
        }
    }

    void deleteByOddIndex() {
        ListIterator<Employee> listIterator = employees.listIterator(employees.size() - 1);
        while(listIterator.hasPrevious()) {
            int index = listIterator.previousIndex();
            listIterator.previous();
            if(index % 2 == 0) {
                listIterator.remove();
            }
        }
    }

    private void format(Employee employee) {
        System.out.println(
            employee
             + "\nСтаж работы: "
             + getYears(employee)
             + " лет");
    }

    private int getYears(Employee employee) {
        return Period.between(employee.getHIRE_DATE(), LocalDate.now()).getYears();
    }

}
