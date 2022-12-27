package Day02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("input2.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);


        String[] list = content.split("\\s+");


        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if(list[i].equals("X")) {
                newList.add(1);
            }

            else if (list[i].equals("Y")) {
                newList.add(2);
            }

            else if (list[i].equals("Z")) {
                newList.add(3);
            }
        }

        int playSum = newList.stream().mapToInt(Integer::intValue).sum();


        List<Integer> newElfList = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if(list[i].equals("A")) {
                newElfList.add(1);
            }

            else if (list[i].equals("B")) {
                newElfList.add(2);
            }

            else if (list[i].equals("C")) {
                newElfList.add(3);
            }
        }


        int winSum = 0;

        for (int a = 0; a < newList.size(); a++) {

            if ((newList.get(a) == 2 && newElfList.get(a) == 1) || (newList.get(a) == 3 && newElfList.get(a) == 2) || (newList.get(a) == 1 && newElfList.get(a) == 3))
                {
                winSum += 6;
            }

            else if (newList.get(a) == newElfList.get(a)) {

                winSum += 3;
            }

            else {
                winSum += 0;
            }
        }

        System.out.println(playSum + winSum);

        List<Integer> updateList = new ArrayList<>();


        for (int b = 0; b < newList.size(); b++) {

            if ((newElfList.get(b) == 1 && newList.get(b) == 1) || (newElfList.get(b) == 2 && newList.get(b) == 3) || (newElfList.get(b) == 3 && newList.get(b) == 2)) {
                updateList.add(3);
            }

            else if ((newElfList.get(b) == 1 && newList.get(b) == 2) || (newElfList.get(b) == 2 && newList.get(b) == 1) || (newElfList.get(b) == 3 && newList.get(b) == 3)) {
                updateList.add(1);
            }

            else if ((newElfList.get(b) == 1 && newList.get(b) == 3) || (newElfList.get(b) == 2 && newList.get(b) == 2) || (newElfList.get(b) == 3 && newList.get(b) == 1))  {
                updateList.add(2);
            }
        }

        int updatePlaySum = updateList.stream().mapToInt(Integer::intValue).sum();

        int updateWinSum = 0;

        for (int a = 0; a < updateList.size(); a++) {

            if ((updateList.get(a) == 2 && newElfList.get(a) == 1) || (updateList.get(a) == 3 && newElfList.get(a) == 2) || (updateList.get(a) == 1 && newElfList.get(a) == 3))
            {
                updateWinSum += 6;
            }

            else if (updateList.get(a) == newElfList.get(a)) {

                updateWinSum += 3;
            }

            else {
                updateWinSum += 0;
            }
        }

        System.out.println(updatePlaySum + updateWinSum);

    }

}

// X = LOSE Y = DRAW Z = WIN
// 1 = LOSE 2 = DRAW 3 = WIN

// A = ROCK B = PAPER C = SCISSORS
// X = ROCK Y = PAPER Z = SCISSORS
// ROCK = 1 PAPER = 2 SCISSORS = 3
// WIN = 6 DRAW = 3 LOSE = 0

// add list to Map
// reset Map after adding [5, 11, etc]

// 1 beats 3
// 2 beats 1
// 3 beats 2
