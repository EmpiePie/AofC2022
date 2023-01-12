package Day08;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("input8a.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);

        String[] list = content.split("\n");

        HashMap<Integer, int []> rows = new HashMap<>();

        for (int i = 0; i < list.length; i++) {

            int[] temp = rowConvert(list[i]);

            rows.put(i, temp);

        }


        int[][] grid = new int[rows.size()][rows.get(1).length ];
        char[][] checkGrid = new char[rows.size()][rows.get(1).length ];

        for (int i = 0; i < rows.size(); i++) {

            int[] temp = rows.get(i);

            for (int j = 0; j < temp.length; j++) {

                grid[i][j] = temp[j];

            }

        }

//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid.length; j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//
//            System.out.println();
//        }


        int visibleTrees = 0;

        visibleTrees += grid.length * 2;
        visibleTrees += (grid[0].length -2) * 2;



        for (int i = 1; i < grid.length -1; i++) {

            int savePoint = grid[i][0];

            for (int j = 1; j < grid[i].length -1; j++) {

                if (grid[i][j] > savePoint) {

                    checkGrid[i][j] = 'A';

                    savePoint = grid[i][j];

                    visibleTrees++;


                }
            }
        }

        for (int i = 1; i < grid.length -1; i++) {

            int savePoint = grid[i][grid[i].length - 1];

            for (int j = grid[i].length -1; j > 0; j--) {

                if (grid[i][j] > savePoint  && checkGrid[i][j] != 'A') {

                    checkGrid[i][j] = 'A';

                    savePoint = grid[i][j];

                    visibleTrees++;

                }

                else if(grid[i][j] > savePoint  && checkGrid[i][j] == 'A') {

                    savePoint = grid[i][j];
                }
            }
        }

        for (int i = 1; i < grid[0].length -1; i++) {

            int savePoint = grid[0][i];

            for (int j = 1; j < grid.length -1; j++) {

                if (grid[j][i] > savePoint && checkGrid[j][i] != 'A') {

                    checkGrid[j][i] = 'A';

                    savePoint = grid[j][i];

                    visibleTrees++;


                }

                else if(grid[j][i] > savePoint && checkGrid[j][i] == 'A') {

                    savePoint = grid[j][i];
                }
            }
        }

        for (int i = 1; i < grid[0].length -1; i++) {

            int savePoint = grid[grid.length -1][i];

            for (int j = grid.length -1; j > 0; j--) {

                if (grid[j][i] > savePoint && checkGrid[j][i] != 'A') {

                    checkGrid[j][i] = 'A';

                    savePoint = grid[j][i];

                    visibleTrees++;

                }

                else if(grid[j][i] > savePoint && checkGrid[j][i] == 'A') {

                    savePoint = grid[j][i];
                }
            }
        }

        System.out.println(visibleTrees);

//        for (int i = 0; i < checkGrid.length; i++) {
//            for (int j = 0; j < checkGrid.length; j++) {
//                System.out.print(checkGrid[i][j] + " ");
//            }
//
//            System.out.println();
//        }
//

        // PART 02

        System.out.println(checkNorth(grid, 3, 2));
        System.out.println(checkSouth(grid, 3, 2));
//        System.out.println(checkWest(grid, 3, 2));
//        System.out.println(checkEast(grid, 3, 2));

//        int highScore = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//
//
//            for (int j = 0; j < grid[i].length; j++) {
//
//                int score = 0;
//
//
//                score = checkNorth(grid, i, j);
//                score *= checkSouth(grid, i, j);
//                score *= checkWest(grid, i, j);
//                score *= checkEast(grid, i, j);
//
//                if (score > highScore) {
//
//                    highScore = score;
//                }
//            }
//        }
//
//        System.out.println(highScore);
//
    }



    public static int[] rowConvert(String str) {
        int[] numbers = new int[str.length() -1];

        for(int i = 0; i < str.length() -1; i++) {
            numbers[i] = str.charAt(i) - '0';
        }
        return numbers;
    }

    public static int checkNorth (int[][] treeGrid, int treeLocationX, int treeLocationY) {


        if (treeLocationX == 0) {

            return 0;
        }

        else {

            int viewDistance = 0;
            int treeToCheck = treeLocationX - 1;

            while (treeGrid[treeLocationX][treeLocationY] > treeGrid[treeToCheck][treeLocationY]) {

                 if (treeToCheck < 0) {

                    break;
                }

                viewDistance++;
                treeToCheck--;

                if (treeGrid[treeLocationX][treeLocationY] <= treeGrid[treeToCheck][treeLocationY]) {

                    viewDistance++;

                    break;
                }

            }

            return viewDistance;
        }

    }

    public static int checkSouth (int[][] treeGrid, int treeLocationX, int treeLocationY) {


        if (treeLocationX == treeGrid.length -1) {

            return 0;

        }

        else {

            int viewDistance = 0;
            int treeToCheck = treeLocationX + 1;

            while (treeGrid[treeLocationX][treeLocationY] > treeGrid[treeToCheck][treeLocationY]) {

                if (treeToCheck > treeGrid.length - 1) {

                    break;
                }

                viewDistance++;
                treeToCheck++;

                if (treeGrid[treeLocationX][treeLocationY] <= treeGrid[treeToCheck][treeLocationY]) {

                    viewDistance++;

                    break;
                }

            }

            return viewDistance;
        }

    }

    public static int checkWest (int[][] treeGrid, int treeLocationX, int treeLocationY) {


        if (treeLocationY == 0) {

            return 0;
        }

        else {

            int viewDistance = 0;
            int treeToCheck = treeLocationY - 1;

            while (treeGrid[treeLocationX][treeLocationY] > treeGrid[treeLocationX][treeToCheck]) {

                if (treeToCheck < 0) {

                    break;
                }

                viewDistance++;
                treeToCheck--;

                if (treeGrid[treeLocationX][treeLocationY] <= treeGrid[treeLocationX][treeToCheck]) {

                    viewDistance++;

                    break;
                }

            }


            return viewDistance;
        }
    }

    public static int checkEast (int[][] treeGrid, int treeLocationX, int treeLocationY) {


        if (treeLocationY == treeGrid.length -1) {

            return 0;
        }

        else {

            int viewDistance = 0;
            int treeToCheck = treeLocationY + 1;

            while (treeGrid[treeLocationX][treeLocationY] > treeGrid[treeLocationX][treeToCheck]) {

                if (treeToCheck > treeGrid[0].length -1) {

                    break;
                }

                viewDistance++;
                treeToCheck++;

                if (treeGrid[treeLocationX][treeLocationY] <= treeGrid[treeLocationX][treeToCheck]) {

                    viewDistance++;

                    break;
                }

            }


            return viewDistance;
        }

    }
}
