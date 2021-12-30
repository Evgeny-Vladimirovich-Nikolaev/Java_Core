public class LogRunner {
    public static void main(String[] args) {
        System.out.println(LogLevel.getLevel("ERROR"));
        Logger logger = new Logger("Информация об ошибке", "ERROR");
        logger.writeLog("./src/main/java/logger/log.txt");
    }
}
