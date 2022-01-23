import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class Employee {

    @XmlAttribute(name = "ID")
    private final int id;
    @XmlAttribute(name = "login")
    private final String login;
    @XmlElement
    private final String lastName;
    @XmlElement
    private final String firstName;
    @XmlElement
    private final String patronymic;

    @XmlElement
    private Department department;
    @XmlElement
    private Post post;

    public Employee() {
        this(-1,
                "none",
                "none",
                "none",
                "none",
                new Department(-1, "none", "none"),
                new Post("none", -1));
    }

}
