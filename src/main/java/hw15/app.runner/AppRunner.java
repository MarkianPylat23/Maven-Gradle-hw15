package hw15.app.runner;

import hw15.operation.WordOperation;

import java.io.IOException;

public class AppRunner {
    private WordOperation fileManager = new WordOperation();

    public void runApp() {
        try {
            fileManager.countAllWords();
            fileManager.countShortWords();
            fileManager.showMostRepeatedWords();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
