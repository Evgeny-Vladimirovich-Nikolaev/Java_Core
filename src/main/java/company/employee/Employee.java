import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class Employee {

    private final int id;
    private final String login;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final LocalDate hireDate;

    private Department department;
    private Post post;

}
