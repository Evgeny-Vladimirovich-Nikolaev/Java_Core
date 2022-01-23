import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@Data
@XmlRootElement(name = "department")
public class Department {

    @XmlElement
    private final  int branchNumber;
    @XmlElement
    private final String branch;
    @XmlElement
    private final String city;

    public Department() {
        this(-1, "none", "none");
    }

}
