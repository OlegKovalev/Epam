package se04.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaFileParserStream {

    private Map<String, Integer> indexMap;
    private String sourceFilePath;
    private String outputFilePath;

    public JavaFileParserStream(String sourceFilePath, String outputFilePath) {
        this.indexMap = new HashMap<>();
        this.sourceFilePath = sourceFilePath;
        this.outputFilePath = outputFilePath;
    }

    public Map<String, Integer> getIndexMap() {
        return indexMap;
    }

    public List<String> getFile() {

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return lines;
    }

    public void findKeyWords(List<String> lines) {

        for (String line : lines) {
            String[] tokens = line.split(" ");
            for (String followWord : tokens) {
                if (KeyWords.KEYWORDS.contains(followWord)) {
                    put(followWord);
                }
            }
        }
    }

    public void put(String word) {

        int count = 0;

        if (indexMap.containsKey(word)) {
            if (indexMap.get(word) == null) {
                count = 0;
            } else {
                count = indexMap.get(word);
            }
            indexMap.put(word, ++count);
        } else {
            indexMap.put(word, 1);
        }
    }

    public void findKeyWordsAndWriteInFile() {

        findKeyWords(getFile());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            String lineToWrite;

            for (String key : indexMap.keySet()) {
                lineToWrite = key + " " + indexMap.get(key);
                bw.write(lineToWrite);
                bw.newLine();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
