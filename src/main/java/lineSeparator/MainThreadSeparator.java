package lineSeparator;

public class MainThreadSeparator {

    private static final String sourcePath = "/Не позволяй душе лениться.txt";
    private static final String outPath = "./src/main/resources/Заболоцкий_";
    private static final String fileNameExtension = ".txt";
    private static final String postFix = " Н.А. Заболоцкий";

    public static void main(String[] args) {
        new LineSeparator(sourcePath, outPath, fileNameExtension, postFix).start();
    }

}
