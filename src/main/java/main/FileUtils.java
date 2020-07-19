package main;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    /**
     * @param path
     * @param lineNumber
     * @return the collected list unless it couldn't read the file or line in that case an empty list
     */

    public static List<String> readFrom(Path path, long lineNumber, boolean inclusive) {
        return getAsStringStream(path).skip(inclusive ? lineNumber - 1 : lineNumber).collect(Collectors.toList());
    }

    /**
     * @param path
     * @param lineNumber
     * @return the content on that line unless it couldn't read the file or line in that case an empty string
     */

    public static String peek(Path path, long lineNumber) {
        Stream<String> lines = getAsStringStream(path);
        Optional<String> str = lines.skip(lineNumber - 1).findFirst();
        return str.orElse("");
    }

    /**
     * @param path
     * @return a random line out of all the lines in that file
     */

    public static String readRandomLine(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            int index = new Random().nextInt(lines.size());
            return lines.get(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param path
     * @return the lines from the file as a {@code Stream}
     */

    private static Stream<String> getAsStringStream(Path path) {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }

}
