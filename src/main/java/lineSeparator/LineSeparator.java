package lineSeparator;

import utils.ResourcesReader;
import utils.ResourcesWriter;

import static java.lang.Character.isDigit;

public class LineSeparator extends Thread{

    private final String sourcePath;
    private final String outPath;
    private final String fileNameExtension;
    private final String postFix;
    private static int index = 1;

    LineSeparator(String sourcePath, String outPath, String fileNameExtension, String postFix) {
        this.sourcePath = sourcePath;
        this.outPath = outPath;
        this.fileNameExtension = fileNameExtension;
        this.postFix = postFix;
    }

    @Override
    public void run() {
        ResourcesReader.readByLines(sourcePath)
                .stream()
                .filter(s -> !s.isEmpty() && !isDigit(s.charAt(0)))
                .map(s -> s + postFix)
                .forEach(s -> ResourcesWriter.writeFile
                        (outPath + index++ + fileNameExtension, s, false));
    }

}
