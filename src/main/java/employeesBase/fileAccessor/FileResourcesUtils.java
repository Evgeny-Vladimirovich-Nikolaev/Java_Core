package fileAccessor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileResourcesUtils {

    private List<String> names;

    public FileResourcesUtils(String fileName, ArrayList<String> names) {
        this.names = names;
        InputStream is = this.getFileFromResourceAsStream(fileName);
        fillNamesList(is);
    }

    // get a file from the resources folder
    private InputStream getFileFromResourceAsStream(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException("Файл " + fileName + " не найден");
            } else {
                return inputStream;
            }
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private void fillNamesList(InputStream is) {
        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
