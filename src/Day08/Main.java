package Day08;

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

        Path filePath = Path.of("input8.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);

        String[] list = content.split("\n");

        HashMap<Integer, int []> rows = new HashMap<>();

        for (int i = 0; i < list.length; i++) {

            int[] temp = rowConvert(list[i]);

            rows.put(i, temp);

        }

        System.out.println(Arrays.toString(rows.get(3)));

        int[][] grid = new int[rows.size()][rows.get(1).length ];
        char[][] checkGrid = new char[rows.size()][rows.get(1).length ];

        for (int i = 0; i < rows.size(); i++) {

            int[] temp = rows.get(i);

            for (int j = 0; j < temp.length; j++) {

                grid[i][j] = temp[j];

            }

        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }

            System.out.println();
        }


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

        for (int i = 0; i < checkGrid.length; i++) {
            for (int j = 0; j < checkGrid.length; j++) {
                System.out.print(checkGrid[i][j] + " ");
            }

            System.out.println();
        }

    }


    public static int[] rowConvert(String str) {
        int[] numbers = new int[str.length() -1];

        for(int i = 0; i < str.length() -1; i++) {
            numbers[i] = str.charAt(i) - '0';
        }
        return numbers;
    }
}
