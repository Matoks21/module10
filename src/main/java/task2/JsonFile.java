package main.java.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JsonFile {

    private static final String ABSOLUTE_PATH = "resources\\file1.txt";
    private List<User> arrayList = new ArrayList<>();

    public void writeUserFile() {
        File file = new File(ABSOLUTE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String text = """
                    name age
                    alice 21
                    ryan 30
                    """;
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFileIntoListUsers() {

        String line;
        File file = new File(ABSOLUTE_PATH);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] array = line.split(" ");
                for (int i = 0; i < array.length; i++) {
                    for (int j = i + 1; j < array.length; j++) {
                        arrayList.add(new User(array[i], Integer.parseInt(array[j])));
                    }
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }

    public void createFileUserJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(arrayList);
        try (FileWriter fileWriter = new FileWriter("resources\\user.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}
