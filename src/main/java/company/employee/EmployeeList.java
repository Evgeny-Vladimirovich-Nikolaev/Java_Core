import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employees_list")
public class EmployeeList {
    @XmlElement(name = "employee")
    private List<Employee> employeeList = new ArrayList<>();

}
