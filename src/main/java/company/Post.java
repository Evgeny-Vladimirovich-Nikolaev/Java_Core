import jakarta.xml.bind.annotation.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Post {

    @XmlElement
    private final String position;
    @XmlElement
    private int salary;

    public Post(String position, int salary) {
        this.position = position;
        this.salary  = salary;
    }

    public Post() {
        this("none", -1);
    }
}
