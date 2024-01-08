package main.java.task1;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stream {
    private static final String ABSOLUTE_PATH = "resources\\file.txt";

    public void writeFile() {
        File file = new File(ABSOLUTE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("""
                    987-123-4567
                    123 456 7890
                    (123) 456-7890
                    (987)-123-4567
                    """);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void readValidNumber() {
        File file = new File(ABSOLUTE_PATH);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();

            while (line != null) {
                Pattern patternoOne = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");//(xxx) xxx-xxxx
                Pattern patternTwo = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");//xxx-xxx-xxxx
                Matcher matcherOne = patternoOne.matcher(line);
                Matcher matcherTwo = patternTwo.matcher(line);

                while (matcherOne.find() || matcherTwo.find()) {
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}