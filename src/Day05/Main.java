package Day05;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("input5.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);

        String[] list = content.split("\n");

        ArrayList<String> updateList = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {

            updateList.add(i, list[i].replace("move", "")
                    .replace("from", "")
                    .replace("to", "")
                    .replaceFirst(" ", ""));
        }


     List<Character> group01 = new ArrayList<>(Arrays.asList('J', 'H', 'G', 'M', 'Z', 'N', 'T', 'F'));
     List<Character> group02 = new ArrayList<>(Arrays.asList('V', 'W', 'J'));
     List<Character> group03 = new ArrayList<>(Arrays.asList('G', 'V', 'L', 'J', 'B', 'T', 'H'));
     List<Character> group04 = new ArrayList<>(Arrays.asList('B', 'P', 'J', 'N', 'C', 'D', 'V', 'L'));
     List<Character> group05 = new ArrayList<>(Arrays.asList('F', 'W', 'S', 'M', 'P', 'R', 'G'));
     List<Character> group06 = new ArrayList<>(Arrays.asList('G', 'H', 'C', 'F', 'B', 'N', 'V', 'M'));
     List<Character> group07 = new ArrayList<>(Arrays.asList('D', 'H', 'G', 'M', 'R'));
     List<Character> group08 = new ArrayList<>(Arrays.asList('H', 'N', 'M', 'V', 'Z', 'D'));
     List<Character> group09 = new ArrayList<>(Arrays.asList('G', 'N', 'F', 'H'));

        HashMap<Integer, List<Character>> groups = new HashMap<>();
        groups.put(1, group01);
        groups.put(2, group02);
        groups.put(3, group03);
        groups.put(4, group04);
        groups.put(5, group05);
        groups.put(6, group06);
        groups.put(7, group07);
        groups.put(8, group08);
        groups.put(9, group09);


        for (int a = 0; a < updateList.size(); a++) {

            String[] tempOrders = updateList.get(a).split("\\s+");
            int[] orders = Arrays.stream(tempOrders).mapToInt(Integer::parseInt).toArray();


            List<Character> tempFrom = groups.get(orders[1]);
            List<Character> tempTo = groups.get(orders[2]);

            int tempFromCopy;

            for (int i = tempFrom.size(); i > (tempFrom.size()- orders[0]) ; i--) {

                tempTo.add(tempFrom.get(i -1));

            }

            groups.put(orders[2], tempTo);


            tempFromCopy = tempFrom.size();

            while (tempFrom.size() > tempFromCopy - orders[0]) {

                tempFrom.remove(tempFrom.size() - 1);

            }

            groups.put(orders[1], tempFrom);

            System.out.println(groups);

        }

        group01 = groups.get(1);
        group02 = groups.get(2);
        group03 = groups.get(3);
        group04 = groups.get(4);
        group05 = groups.get(5);
        group06 = groups.get(6);
        group07 = groups.get(7);
        group08 = groups.get(8);
        group09 = groups.get(9);

        System.out.println(group01);
        System.out.println(group02);
        System.out.println(group03);
        System.out.println(group04);
        System.out.println(group05);
        System.out.println(group06);
        System.out.println(group07);
        System.out.println(group08);
        System.out.println(group09);



        System.out.println(group01.get(group01.size() -1).toString() + group02.get(group02.size() -1) + group03.get(group03.size() -1) +
                group04.get(group04.size() -1) + group05.get(group05.size() -1) + group06.get(group06.size() -1) + group07.get(group07.size() -1) +
                group08.get(group08.size() -1) + group09.get(group09.size() -1));

    }
}
