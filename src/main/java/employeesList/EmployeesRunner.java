public class EmployeesRunner {

    public static void main(String[] args) {
        EmployeeUtils employees = new EmployeeUtils(new EmployeesList().create());
        employees.printAll();
        employees.printWithWorkAge(10);
        employees.printWithWorkAge(20);
        employees.printWithWorkAge(35, true);
        employees.printWithWorkAge(3, false);
        employees.deleteByOddIndex();
        employees.printAll();
    }

}
