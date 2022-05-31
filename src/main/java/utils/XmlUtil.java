package utils;

import company.employee.EmployeeList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.nio.file.Path;

public class XmlUtil {

    public static void writeInXML(EmployeeList list, Path path) {
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(list, new File(path.toString()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static EmployeeList readFromXML(Path path) {
        EmployeeList employees = null;
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            employees = (EmployeeList) unmarshaller.unmarshal(new File(path.toString()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
         return employees;
    }
}
