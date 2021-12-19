public class EmployeesRunner {

    public static void main(String[] args) {
        EmployeeUtils employees = new EmployeeUtils(new EmployeesList().create());
        employees.getAll();
        employees.getWithWorkAge(10);
        employees.getWithWorkAge(20);
        employees.getWithWorkAge(35, true);
        employees.getWithWorkAge(3, false);
        employees.deleteByOddIndex();
        employees.getAll();
    }

}
