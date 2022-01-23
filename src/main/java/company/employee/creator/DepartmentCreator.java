import creator.Branches;

import java.util.Random;

public class DepartmentCreator {

    private DepartmentCreator() {}

    public static Department getDepartment(int id) {
        if(id < AdministerPositionSalary.values().length) {
            return new Department(
                    Branches.HEAD_OFFICE.getBranchNumber(),
                    Branches.HEAD_OFFICE.getBranch(),
                    Branches.HEAD_OFFICE.getCity());
        } else {
            Branches branch = Branches.values()[new Random().nextInt(Branches.values().length)];
            return new Department(
                    branch.getBranchNumber(),
                    branch.getBranch(),
                    branch.getCity()
            );
        }
    }
}
