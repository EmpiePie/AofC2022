package Day04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("input4.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);

        String[] list = content.split("\n");


        int totalOverlaps = 0;
        int partOverlaps = 0;

        ArrayList<Integer> checkOverLap = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {

            String[] group = list[i].split(",", 2);

            String[] subGroup1 = group[0].split("-", 2);
            String[] subGroup2 = group[1].split("-", 2);

            int minGroup01 = Integer.parseInt(subGroup1[0]);
            int maxGroup01 = Integer.parseInt(subGroup1[1]);
            int minGroup02 = Integer.parseInt(subGroup2[0]);
            int maxGroup02 = Integer.parseInt(subGroup2[1]);


            int[] dutyList1 = IntStream.rangeClosed(minGroup01, maxGroup01).toArray();
            int[] dutyList2 = IntStream.rangeClosed(minGroup02, maxGroup02).toArray();

            int dutyList1Min = dutyList1[0];
            int dutyList1Max = dutyList1[dutyList1.length - 1];
            int dutyList2Min = dutyList2[0];
            int dutyList2Max = dutyList2[dutyList2.length - 1];


            if ((dutyList1Min >= dutyList2Min && dutyList1Max <= dutyList2Max) || (dutyList2Min >= dutyList1Min && dutyList2Max <= dutyList1Max)) {
                totalOverlaps += 1;

                checkOverLap.add(1);
            }

            // Min1 < Min2 && Max1 < Max2 && Max1 >= Min2

            // Min 1 > Min2 && Max1 > Max2 && Min1 <= Max2

            else if (dutyList1Min < dutyList2Min && dutyList1Max >= dutyList2Min)
            {

                partOverlaps += 1;

                checkOverLap.add(1);
            }

            else if (dutyList1Min > dutyList2Min && dutyList1Min <= dutyList2Max)
            {

                partOverlaps += 1;

                checkOverLap.add(1);
            }

            else {

                checkOverLap.add(0);
            }

            System.out.println(dutyList1Min + "-" + dutyList1Max + ", " + dutyList2Min + "-" + dutyList2Max + " : " + checkOverLap.get(i));

        }
        System.out.println(totalOverlaps);
        System.out.println(partOverlaps + totalOverlaps);
    }
}
