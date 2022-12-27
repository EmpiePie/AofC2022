package Day01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("input.txt");
        String content = Files.readString(filePath, StandardCharsets.UTF_8);

        String[] list = content.split("\n");

        //

        int elf = 1;
        int cal = 0;

        HashMap<Integer, Integer> ElfMap = new HashMap<>();

        //

        for (int i = 0; i < list.length; i++)
        {
            if(list[i].isBlank()){
                //
                ElfMap.put(elf, cal);
                cal = 0;
                elf++;
            }

            else {
                cal += Integer.parseInt(list[i]);

            }
        }

        List<Map.Entry<Integer, Integer>> newList = new ArrayList<>(ElfMap.entrySet());

        newList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println(newList.get(0).getValue());


        int sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += newList.get(i).getValue();
        }
        System.out.println(sum);
    }
}

// Map<Integer, Integer> sortedMap = sortByValue(ElfMap);


//elfList.sort(Collections.reverseOrder());


//    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> ElfMap) {
//
//        List<Map.Entry<Integer, Integer>> newList = new LinkedList<Map.Entry<Integer, Integer>>(ElfMap.entrySet());
//
//        newList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return (o1.getValue()).compareTo(o2.getValue());
//            }
//        });
//
//        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
//        for (Map.Entry<Integer, Integer> entry : newList) {
//            sortedMap.put(entry.getKey(), entry.getValue());
//        }
//
//        return sortedMap;
//
//    }

//    public static class ElfCal {
//        public int cal;
//        public int elf;
//
//        public ElfCal(int cal, int elf) {
//            this.cal = cal;
//            this.elf = elf;
//        }
//    }


// System.out.println(Arrays.asList(list));
// List<ElfCal> elfList = new ArrayList<>();
//elfList.add(new ElfCal(cal, elf));