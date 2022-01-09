import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import static java.lang.Character.isDigit;

public class CallableLineSeparator extends Thread implements Callable<List<String>> {

    private final String sourcePath;
    private final String postFix;

    CallableLineSeparator(String sourcePath, String postFix) {
        this.sourcePath = sourcePath;
        this.postFix = postFix;
    }

    @Override
    public List<String> call(){
        return
                ResourcesReader.readByLines(sourcePath)
                .stream()
                .filter(s -> !s.isEmpty() && !isDigit(s.charAt(0)))
                .map(s -> s + postFix)
                .collect(Collectors.toList());
    }


}