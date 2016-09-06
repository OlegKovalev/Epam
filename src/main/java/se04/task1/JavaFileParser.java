package se04.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaFileParser {

    private Map<String, Integer> indexMap;
    private String sourceFilePath;
    private String outputFilePath;

    public JavaFileParser(String sourceFilePath, String outputFilePath) {
        this.indexMap = new HashMap<>();
        this.sourceFilePath = sourceFilePath;
        this.outputFilePath = outputFilePath;
    }

    public Map<String, Integer> getIndexMap() {
        return indexMap;
    }

    public void findKeyWordsAndWriteInFile() {
        findKeyWords(getFile());

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFilePath))) {
            String lineToWrite;

            for (String key : indexMap.keySet()) {
                lineToWrite = key + " " + indexMap.get(key) + "\n";
                bos.write(lineToWrite.getBytes());
            }
        } catch (FileNotFoundException exc) {
            System.out.println("File not found");
        } catch (IOException exc) {
            System.out.println("Exception");
        }
    }
    
    private List<String> getFile() {

        List<String> lines = new ArrayList<>();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath))) {
            byte[] buffer = new byte[2048];
            int character;

            while ((character = bis.read(buffer)) != -1) {
                lines.add(new String(buffer, 0, character));
            }
        } catch (FileNotFoundException exc) {
            System.out.println("File not found");
        } catch (IOException exc) {
            System.out.println("Exception");
        }
        return lines;
    }

    private void findKeyWords(List<String> lines) {

        for (String line : lines) {
            line.trim();
            String[] tokens = line.split("[\\s\\\\(]");
            for (String followWord : tokens) {
                if (KeyWords.KEYWORDS.contains(followWord)) {
                    put(followWord);
                }
            }
        }
    }

    private void put(String word) {
        int count = 0;

        if (indexMap.containsKey(word)) {
            count = indexMap.get(word);
            indexMap.put(word, ++count);
        } else {
            indexMap.put(word, 1);
        }
    }
}