package hw15.operation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordOperation {
    private String bufferedReader = "src/main/resources/data.txt";
    private String bufferedWriter = "src/main/resources/addData.txt";

    public void countAllWords() throws IOException {
        FileReader frForCountWords = new FileReader(bufferedReader);
        BufferedReader brForCountWords = new BufferedReader(frForCountWords);

        String currentLine;
        int counterOfWords = 0;
        while ((currentLine = brForCountWords.readLine()) != null) {
            String[] songInArray = currentLine.split(" ");
            counterOfWords = counterOfWords + songInArray.length;
        }
        frForCountWords.close();
        System.out.println("Amount of words in song: " + counterOfWords + "\n");
    }

    public void countShortWords() throws IOException {
        FileReader frForShortWords = new FileReader(bufferedReader);
        BufferedReader brForShortWords = new BufferedReader(frForShortWords);
        FileWriter fwForShortWords = new FileWriter(bufferedWriter);
        BufferedWriter bwForShortWords = new BufferedWriter(fwForShortWords);

        String currentLine;
        int numberOfShortWords = 0;
        while ((currentLine = brForShortWords.readLine()) != null) {
            String[] shortWordsInArray = currentLine.split(" ");

            for (String shortWords : shortWordsInArray) {
                if (shortWords.length() <= 3 && !shortWords.equals("" + "")) {
                    bwForShortWords.write(shortWords + "\n");
                    bwForShortWords.flush();

                    numberOfShortWords++;
                }
            }
        }
        frForShortWords.close();
        fwForShortWords.close();
        System.out.println("Amount of short words in song: " + numberOfShortWords + "\n");
    }

    public void showMostRepeatedWords() throws IOException {
        FileReader frForRepeatedWords = new FileReader(bufferedReader);
        BufferedReader brForRepeatedWords = new BufferedReader(frForRepeatedWords);
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();

        String currentLine = brForRepeatedWords.readLine();
        while (currentLine != null) {
            String[] words = currentLine.toLowerCase().split(" ");
            for (String repeatedWord : words) {
                if (wordCountMap.containsKey(repeatedWord)) {
                    wordCountMap.put(repeatedWord, wordCountMap.get(repeatedWord) + 1);
                } else {
                    wordCountMap.put(repeatedWord, 1);
                }
            }
            currentLine = brForRepeatedWords.readLine();
        }

        String mostRepeatedWord = null;
        int count = 0;
        Set<Map.Entry<String, Integer>> entrySet = wordCountMap.entrySet();

        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() > count) {
                mostRepeatedWord = entry.getKey();
                count = entry.getValue();
            }
        }
        System.out.println("The most repeated word in input file is : " + mostRepeatedWord + "\n");
        System.out.println("Amount of repeats : " + count);
        brForRepeatedWords.close();
    }
}
