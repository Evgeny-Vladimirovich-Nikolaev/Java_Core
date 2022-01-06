import java.util.List;
import java.util.stream.Collectors;


public class LineSeparator {

    private static final String path = "./src/main/resources/Не позволяй душе лениться.txt";

    public static void main(String[] args) {
        write(ResourcesReader.readByLines(path).stream()
                    .filter(s -> s.length() != 0)
                    .map(s -> s + "Заболоцкий")
                .collect(Collectors.toList()));
    }

    private static void write(List<String> lines) {

    }

}
