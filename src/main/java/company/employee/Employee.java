package company.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import company.Department;
import company.Post;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@XmlRootElement
public class Employee {

    @XmlAttribute(name = "ID")
    @JsonProperty("ID")
    private final int id;
    @XmlAttribute(name = "login")
    @JsonProperty("login")
    private final String login;
    @XmlElement
    @JsonProperty("lastName")
    private final String lastName;
    @XmlElement
    @JsonProperty("firstName")
    private final String firstName;
    @XmlElement
    @JsonProperty("patronymic")
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
