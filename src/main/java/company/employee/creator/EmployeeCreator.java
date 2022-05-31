package company.employee.creator;

import company.Department;
import company.Post;
import company.employee.Employee;
import utils.NameCreator;
import utils.Transliterator;

import java.util.Random;

public class EmployeeCreator {

    private static int id = 0;

    private EmployeeCreator() {
    }

    public static Employee createEmployee() {
        String[] name = NameCreator.createFIO();
        return new Employee(
                ++id,
                getLogin(name[0]),
                name[0],
                name[1],
                name[2],
                getDepartment(),
                getPost());
    }

    private static String getLogin(String name) {
        return Transliterator.translit(name) + "_" + id;
    }

    private static Department getDepartment() {
        if ((id - 1) <= AdministerPositionSalary.values().length) {
            return new Department(
                    Branches.HEAD_OFFICE.getBranchNumber(),
                    Branches.HEAD_OFFICE.getBranch(),
                    Branches.HEAD_OFFICE.getCity());
        }
        Branches branch = Branches.values()[new Random().nextInt(Branches.values().length)];
        return new Department(
                branch.getBranchNumber(),
                branch.getBranch(),
                branch.getCity()
        );
    }

    private static Post getPost() {
        if ((id) <= AdministerPositionSalary.values().length) {
            AdministerPositionSalary position = AdministerPositionSalary.values()[id - 1];
            return new Post(
                    position.getPosition(),
                    position.getSalary()
            );
        }
        int rnd = new Random().nextInt(PositionSalary.values().length);
        PositionSalary position = PositionSalary.values()[rnd];
        return new Post(
                position.getPosition(),
                position.getSalary()
        );
    }
}
