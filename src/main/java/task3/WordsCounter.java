package main.java.task3;

import main.java.task2.User;

import java.io.*;
import java.util.*;

public class WordsCounter {

    private List<String> arrayList = new ArrayList<>();
    private static final String ABSOLUTE_PATH = "resources\\words.txt";

    public void writeFile() {
        File file = new File(ABSOLUTE_PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("the day is sunny the the\n" +
                    "the sunny is is");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void countNumberOfWords() {

        String line;
        File file = new File(ABSOLUTE_PATH);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                String[] array = line.split(" ");
                Collections.addAll(arrayList, array);
            }
            printList();
      /*     TreeMap<Integer,String> map=new TreeMap(Comparator.reverseOrder());
            for (String arr:arrayList) {
                int frequency = Collections.frequency(arrayList, arr);
               map.put(frequency,arr);
            }

            for (Map.Entry<Integer,String>entry: map.entrySet()) {
                System.out.println(entry.getValue()+" "+entry.getKey());
            }

       */
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void printList() {
        Set<String> stringSet = new HashSet<>(arrayList);
        for (String str : stringSet) {
            System.out.println(str + " " + Collections.frequency(arrayList, str));
        }

    }
}
