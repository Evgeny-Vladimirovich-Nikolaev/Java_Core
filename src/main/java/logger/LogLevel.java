public enum LogLevel {

    ERROR(5),
    WARN(4),
    INFO(3),
    DEBUG(2),
    TRACE(1),
    ALL(0);

    private int level;

    LogLevel(int level) {
        this.level = level;
    }

    public static int getLevel(String s) {
        return valueOf(s).level;
    }
}
