package company.employee.creator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionSalary {

    CASHIER("Кассир", 18_000),
    CONDUCTOR("Проводник", 16_000),
    DISPATCHER("Диспетчер", 20_000),
    ELECTRICIAN("Электрик", 23_000),
    ENGINEER("Инженер", 24_000),
    MACHINIST("Машинист", 100_000),
    MACHINIST_ASSISTANT("Помощник машиниста", 55_000),
    MECHANIC("Механик", 24_000),
    MOVER("Движенец", 17_000),
    SECURITY("Инспектор досмотра", 25_000),
    STATION_MASTER("Начальник станции", 75_000),
    TECHNICIAN("Техник", 23_500),
    TRAIN_HEAD("Начальник поезда", 30_000);

    private String position;
    private int salary;

}
