import creator.PositionSalary;
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
                    creator.Branches.HEAD_OFFICE.getBranchNumber(),
                    creator.Branches.HEAD_OFFICE.getBranch(),
                    creator.Branches.HEAD_OFFICE.getCity());
        }
        creator.Branches branch = creator.Branches.values()[new Random().nextInt(creator.Branches.values().length)];
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
