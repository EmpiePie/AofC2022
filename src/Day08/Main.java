package Day08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("input8.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);

        String[] list = content.split("\n");

        HashMap<Integer, int []> rows = new HashMap<>();

        for (int i = 0; i < list.length; i++) {

            int[] temp = rowConvert(list[i]);

            rows.put(i + 1, temp);

        }

        HashMap<Integer, List<Integer>> columns = new HashMap<>();


        for (int i = 0; i < rows.get(1).length; i++) {

            List<Integer> a = new ArrayList<>();

            for (int j = 0; j < rows.size(); j++) {

                int[] temp1 = rows.get(j + 1);

                a.add(temp1[i]);

            }

            columns.put(i + 1, a);
        }


        int visibleTrees = 0;

        visibleTrees += rows.get(1).length;
        visibleTrees += rows.get(rows.size()).length;

        for (int i = 2; i < rows.size(); i++) {

            visibleTrees += 2;

        }

        for (int j = 2; j < rows.size() -1; j++) {

            int[] temp2 = rows.get(j);

            for (int i = 1; i < rows.get(i).length; i++) {

                if (temp2[i] > temp2[i - 1]) {

                    visibleTrees++;
                }

            }
        }

        for (int j = 2; j < rows.size() -1; j++) {

            int[] temp2 = rows.get(j);

            for (int i = temp2.length - 1; i > 0; i--) {

                if (temp2[i - 1] > temp2[i]) {

                    visibleTrees++;
                }

            }
        }

        System.out.println(visibleTrees);

    }

    public static int[] rowConvert(String str) {
        int[] numbers = new int[str.length()];

        for(int i = 0; i < str.length(); i++) {
            numbers[i] = str.charAt(i) - '0';
        }
        return numbers;
    }
}
