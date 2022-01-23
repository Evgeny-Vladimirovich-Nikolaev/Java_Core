import jakarta.xml.bind.annotation.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Post {

    @XmlAttribute(name = "position")
    private final String position;
    @XmlAttribute(name = "salary")
    private int salary;

    public Post(String position, int salary) {
        this.position = position;
        this.salary  = salary;
    }

    public Post() {
        this("none", -1);
    }
}
