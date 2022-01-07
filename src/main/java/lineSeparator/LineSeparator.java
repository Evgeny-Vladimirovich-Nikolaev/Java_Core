import static java.lang.Character.isDigit;

public class LineSeparator {

    private static int index = 1;

    public static void main(String[] args) {
        ResourcesReader.readByLines("Не позволяй душе лениться.txt")
                .stream()
                .filter(s -> !s.isEmpty() && !isDigit(s.charAt(0)))
                .map(s -> s + " Н.А. Заболоцкий")
            .forEach(s -> ResourcesWriter.writeFile
                    ("./src/main/resources/Заболоцкий_" + index++ + ".txt", s, false));
    }

}
