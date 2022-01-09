import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainCallableSeparator {

    private static String sourcePath = "Не позволяй душе лениться.txt";
    private static String outPath = "./src/main/resources/Заболоцкий_";
    private static String fileNameExtension = ".txt";
    private static String postFix = " Н.А. Заболоцкий";

    public static void main(String[] args) {
        List<String> lines = new LinkedList<>();
        try {
            lines = new CallableLineSeparator(sourcePath, postFix).call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(lines);
    }
}
