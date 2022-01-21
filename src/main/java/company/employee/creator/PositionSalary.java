package creator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionSalary {

    GENERAL_MANAGER("Генеральный директор", 5_000_000),
    FIRST_DEPUTY("Первый заместитель", 2_500_000),
    SECOND_DEPUTY("Второй заместитель", 1_500_000),
    GENERAL_ENGINEER("Главный инженер", 1_000_000),
    GENERAL_ACCOUNTANT("Главный бухгалтер", 1_000_000),
    CASHIER("Кассир", 18_000),
    CONDUCTOR("Проводник", 16_000),
    DISPATCHER("Диспетчер", 20_000),
    ELECTRICIAN("Электрик", 23_000),
    ENGINEER("Инженер", 5_000_000),
    MACHINIST("Машинист", 100_000),
    MACHINIST_ASSISTANT("Помощник машиниста", 55_000),
    MECHANIC("Механик", 24_000),
    MOVER("Движенец", 17_000),
    SECURITY("Инспектор досмотра", 25_000),
    STATION_MASTER("Начальник станции", 75_000),
    TECHNICIAN("Техник", 23_500),
    TRAIN_HEAD("", 30_000);

    private String position;
    private int salary;

}
