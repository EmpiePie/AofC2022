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


        int visibleTrees = 0;

        visibleTrees += rows.get(1).length * 2;

        for (int j = 2; j < rows.size(); j++) {

            int[] temp = rows.get(j);
            int savePoint = temp[0];

            for (int i = 0; i < temp.length -2; i++) {

                if (temp[i + 1] > savePoint) {

                    savePoint = temp[i + 1];

                    temp[i + 1] = -1;

                    visibleTrees++;

                }
            }
            rows.put(j, temp);
        }


        for (int j = 2; j < rows.size() -1; j++) {

            int[] temp = rows.get(j);
            int savePoint = temp[temp.length - 1];

            for (int i = temp.length - 1; i > 1; i--) {

                if (temp[i - 1] > savePoint && temp[i - 1] > 0){

                    savePoint = temp[i - 1];

                    temp[i - 1] = -1;

                    visibleTrees++;
                }

            }
            rows.put(j, temp);
        }

        HashMap<Integer, List<Integer>> columns = new HashMap<>();


        for (int i = 0; i < rows.get(1).length; i++) {

            List<Integer> a = new ArrayList<>();

            for (int j = 0; j < rows.size(); j++) {

                int[] temp = rows.get(j + 1);

                a.add(temp[i]);

            }

            columns.put(i + 1, a);
        }

        for (int j = 2; j < columns.size(); j++) {

            List<Integer> temp = columns.get(j);
            int savePoint = temp.get(0);

            for (int i = 0; i < temp.size() - 2; i++) {

                if (temp.get(i + 1) > savePoint && temp.get(i + 1) > 0) {

                    savePoint = temp.get(i + 1);

                    temp.set(i + 1, -1);

                    visibleTrees++;
                }

            }

            columns.put(j, temp);
        }

        for (int j = 2; j < columns.size() -1; j++) {

            List<Integer> temp = columns.get(j);

            int savePoint = temp.get(temp.size() - 1);

            for (int i = temp.size() - 1; i > 0; i--) {

                if (temp.get(i - 1) > savePoint && temp.get(i - 1) > 0) {

                    savePoint = temp.get(i - 1);

                    temp.set(i - 1, -1);

                    visibleTrees++;
                }

            }
            columns.put(j, temp);
        }

        visibleTrees += (columns.size() - 2) * 2;

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
