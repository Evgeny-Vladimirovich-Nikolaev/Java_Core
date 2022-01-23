import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AdministerPositionSalary {

    GENERAL_MANAGER("Генеральный директор", 5_000_000),
    FIRST_DEPUTY("Первый заместитель", 2_500_000),
    SECOND_DEPUTY("Второй заместитель", 1_500_000),
    GENERAL_ENGINEER("Главный инженер", 1_000_000),
    GENERAL_ACCOUNTANT("Главный бухгалтер", 1_000_000);

    private String position;
    private int salary;

}
