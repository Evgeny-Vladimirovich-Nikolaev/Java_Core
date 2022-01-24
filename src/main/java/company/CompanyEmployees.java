import jakarta.xml.bind.JAXBException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CompanyEmployees {

    private static final String PATH = "./src/main/resources/employee.xml";

    private static ArrayList<Employee> employees = new ArrayList<>(1000);

    public static void main(String[] args) throws JAXBException {
        for (int i = 0; i < 1000; i++) {
            employees.add(EmployeeCreator.createEmployee());
        }
        EmployeeList employeeList = new EmployeeList();
        employeeList.getEmployeeList().addAll(employees);

        XmlUtil.writeInXML(employeeList, Paths.get(PATH));

        EmployeesUtil employeesUtil = new EmployeesUtil(PATH);
        employeesUtil.aboveAverageSalary();
    }

}
