package Day08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("input8.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);
    }
}
