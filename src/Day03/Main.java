package Day03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("input3.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);

        String[] list = content.split("\n");

        int charSum = 0;

        for (int a = 0; a < list.length; a++) {

            String text = list[a];
            int stringCount = list[a].length();

            String pack = Arrays.toString(splitToNChar(text, stringCount / 2));

            String updatePack = pack.replaceAll("[\\[\\]\\s]", "");

            String[] finalPack = updatePack.split(",", 2);

            String str1 = finalPack[0];
            String str2 = finalPack[1];

            String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

            int charNumber = alphabet.indexOf(matchingChar(str1, str2)) + 1;

            charSum += charNumber;
        }

        System.out.println(charSum);

    }

    private static String[] splitToNChar(String text, int size) {
        List<String> parts = new ArrayList<>();

        int length = text.length();
        for (int i = 0; i < length; i += size) {
            parts.add(text.substring(i, Math.min(length, i + size)));
        }
        return parts.toArray(new String[0]);
    }

    private static Character matchingChar(String str1, String str2) {

        List<Character> word1 = new ArrayList<>();
        List<Character> word2 = new ArrayList<>();

        for (int i = 0; i < str1.length(); i++) {

            char ch1 = str1.charAt(i);
            word1.add(ch1);

            char ch2 = str2.charAt(i);
            word2.add(ch2);
        }

        char targetChar;

        for (int k = 0; k < word2.size(); k++) {

            for (int j = 0; j < word1.size(); j++) {

                if (word1.get(j) == word2.get(k)) {
                    targetChar = word1.get(j);
                    return targetChar;
                }
            }
    }
        return null;
    }

}
