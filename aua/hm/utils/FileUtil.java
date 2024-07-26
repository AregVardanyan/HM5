package am.aua.hm.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    public static void saveStringsToFile(String[] content, String path) throws IOException {
        Files.write(Paths.get(path), java.util.Arrays.asList(content));
    }

    public static String[] loadStringsFromFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
    }
}
