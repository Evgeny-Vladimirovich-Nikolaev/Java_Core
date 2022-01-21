package creator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private final String position;
    private int salary;

    public Post(String position, int salary) {
        this.position = position;
        this.salary  = salary;
    }
}
