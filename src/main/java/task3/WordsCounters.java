package main.java.task3;

public class WordsCounters {
    public static void main(String[] args) {
        WordsCounter wordsCounter = new WordsCounter();
        wordsCounter.writeFile();
        wordsCounter.countNumberOfWords();
    }
}
