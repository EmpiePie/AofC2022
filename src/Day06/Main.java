package Day06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("input6.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);

        int charNumber = 4;

        while (true) {

            String sequence = content.substring(0, 4);

            if (checkDuplicateChars(sequence)) {

                content = content.substring(1, content.length());
                charNumber++;
            }

            else {
                break;
            }
        }
        System.out.println(charNumber);

        content = Files.readString(filePath, StandardCharsets.UTF_8);

        int msgNumber = 14;

        while (true) {

            String sequence = content.substring(0, 14);

            if (checkDuplicateChars(sequence)) {

                content = content.substring(1, content.length());
                msgNumber++;
            }

            else {
                break;
            }
        }
        System.out.println(msgNumber);
    }

    public static boolean checkDuplicateChars (String str) {

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j < str.length(); j++) {

                if (str.charAt(i) == str.charAt(j)) {

                    return true;
                }
            }
        }
        return false;
    }
}
