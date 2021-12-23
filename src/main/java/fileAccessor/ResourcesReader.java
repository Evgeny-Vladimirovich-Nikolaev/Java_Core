import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ResourcesReader implements Closeable {

    private ResourcesReader() {}

    private static InputStream getFileFromResourceAsStream(String fileName) {
        try {
            Class cls = ResourcesReader.class;
            InputStream inputStream = cls.getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException("Файл " + fileName + " не найден");
            } else {
                return inputStream;
            }
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static ArrayList<String> readLines(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        InputStream stream = getFileFromResourceAsStream(fileName);
        try (InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Не удалось прочитать файл ресурсов");
            lines.add("нет данных");
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Ошибка ввода/вывода: не удалось закрыть поток");
                e.printStackTrace();
            }
        }
        return lines;
    }

    @Override
    public void close() throws IOException {

    }
}
