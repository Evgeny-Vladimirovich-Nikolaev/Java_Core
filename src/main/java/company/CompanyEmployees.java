import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CompanyEmployees {

    private static ArrayList<Employee> employees = new ArrayList<>(1000);

    public static void main(String[] args) throws JAXBException {
        for (int i = 0; i < 1000; i++) {
            employees.add(EmployeeCreator.createEmployee());
        }
        EmployeeList employeeList = new EmployeeList();
        employeeList.getEmployeeList().addAll(employees);

        XmlUtil.writeInXML(employeeList, Paths.get("./src/main/resources/employee.xml"));
        writeToXML(employeeList);
    }

    private static void writeToXML(EmployeeList employeeList) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(employeeList, stringWriter);
        System.out.println("XML: " + stringWriter);
    }

}
