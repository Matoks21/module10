package main.java.task2;

public class JsonFiles {

    public static void main(String[] args) {
        JsonFile newJson = new JsonFile();
        newJson.writeUserFile();
        newJson.readFileIntoListUsers();
        newJson.createFileUserJson();

    }
}
