public class MainThreadSeparator {

    private static String sourcePath = "Не позволяй душе лениться.txt";
    private static String outPath = "./src/main/resources/Заболоцкий_";
    private static String fileNameExtension = ".txt";
    private static String postFix = " Н.А. Заболоцкий";

    public static void main(String[] args) {
        new LineSeparator(sourcePath, outPath, fileNameExtension, postFix).start();
    }

}
