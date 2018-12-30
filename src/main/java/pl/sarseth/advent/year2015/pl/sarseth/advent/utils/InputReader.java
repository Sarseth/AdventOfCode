package pl.sarseth.advent.year2015.pl.sarseth.advent.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputReader {

    public static String readInput(String inputName) {
        StringBuilder contentBuilder = new StringBuilder();
        Path path = Paths.get(System.getProperty("user.dir") + "/src/main/resource/input" + inputName);
        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static List<String> readInputAndDivide(String inputName) {
        String readInput = readInput(inputName);
        return Arrays.asList(readInput.split("\n"));
    }

}
