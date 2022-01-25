import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CompanyEmployees {

    private static final String PATH = "./src/main/resources/employee.xml";

    private static ArrayList<Employee> employees = new ArrayList<>(1000);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            employees.add(EmployeeCreator.createEmployee());
        }
        EmployeeList employeeList = new EmployeeList();
        employeeList.getEmployeeList().addAll(employees);

        XmlUtil.writeInXML(employeeList, Paths.get(PATH));

        EmployeesUtil employeesUtil = new EmployeesUtil(PATH);
        employeesUtil.aboveAverageSalary();

        writeJson();
    }

    private static void writeJson() {
        try {
            String json = XML.toJSONObject(String.join("", Files.readAllLines(Paths.get(PATH)))).toString();
            Path jsonPath = Paths.get(PATH).getParent().resolve("employee.json");
            Files.writeString(jsonPath, json, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            printOddEmployees(jsonPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printOddEmployees(Path jsonPath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        TypeReference<EmployeeList> typeRef = new TypeReference<>() {};
        System.out.println("--------------------------------------------------------");
        System.out.println("СПИСОК СОТРУДНИКОВ С НЕЧЕТНЫМ ИНДЕКСОМ В Json-ФАЙЛЕ");
        try {
            EmployeeList oddList = objectMapper.readValue(jsonPath.toFile(), typeRef);
            oddList
                    .getEmployeeList()
                    .stream()
                    .filter(employee -> oddList.getEmployeeList().indexOf(employee) % 2 == 1)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
