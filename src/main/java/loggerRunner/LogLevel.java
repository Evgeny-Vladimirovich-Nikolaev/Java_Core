package loggerRunner;

public enum LogLevel {

    ERROR(4, "Ошибка выполнения"),
    WARN(3, "Предупреждение"),
    INFO(2, "Отчет выполнения программы"),
    DEBUG(1, "Важное событие в программе"),
    TRACE(0, "Трассировка стека");

    private int level;
    private String msg;

    LogLevel(int level, String msg) {
        this.level = level;
        this.msg = msg;
    }

    public static int getLevel(String status) {
        return valueOf(status).level;
    }

    public static String getMsg(String status) {
        return valueOf(status).msg;
    }
 }
