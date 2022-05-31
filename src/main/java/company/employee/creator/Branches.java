package company.employee.creator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Branches {

    HEAD_OFFICE(0, "Головной офис", "Москва"),
    OCTOBER_RAILWAY(1, "Октябрьская железная дорога", "Санкт-Петербург"),
    KALININGRAD_RAILWAY(2, "Калининградская железная дорога", "Калининград"),
    MOSCOW_RAILWAY(3, "Московская железная дорога", "Москва"),
    GORKY_RAILWAY(4, "Горьковская железная дорога", "Нижний Новгород"),
    NORTHERN_RAILWAY(5, "Северная железная дорога", "Ярославль"),
    KAVKAZ_RAILWAY(6, "Северо-Кавказская железная дорога", "Ростов-на-Дону"),
    VORONEZH_RAILWAY(7, "Юго-Восточная железная дорога", "Воронеж"),
    VOLGA_RAILWAY(8, "Приволжская железная дорога", "Саратов"),
    KUIBYSHEV_RAILWAY(9, "Куйбышевская железная дорога", "Самара"),
    SVERDLOVSK_RAILWAY(10, "Свердловская железная дорога", "Екатеринбург"),
    URAL_RAILWAY(11, "Южно-Уральская железная дорога", "Челябинск"),
    WEST_SIBERIAN_RAILWAY(12, "Западно-Сибирская железная дорога", "Новосибирск"),
    KRASNOYARSK_RAILWAY(13, "Красноярская железная дорога", "Красноярск"),
    EAST_SIBERIAN_RAILWAY(14, "Восточно-Сибирская железная дорога", "Иркутск"),
    BAIKAL_RAILWAY(15, "Забайкальская железная дорога", "Чита"),
    EAST_RAILWAY(16, "Дальневосточная железная дорога", "Хабаровск");

    private int branchNumber;
    private String branch;
    private String city;

}
