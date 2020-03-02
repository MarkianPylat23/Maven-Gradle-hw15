package hw15.app.runner;

import hw15.operation.WordOperation;

public class AppRunner {
    private WordOperation fileManager = new WordOperation();

    public void runApp() {
        fileManager.addWords();
        fileManager.addShortWords();
        fileManager.addMostRepeatedWords();
    }
}
