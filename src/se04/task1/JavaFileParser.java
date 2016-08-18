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
    private static final byte DELIMITER = (byte) '\n';

    public JavaFileParser(String sourceFilePath, String outputFilePath) {
        this.indexMap = new HashMap<>();
        this.sourceFilePath = sourceFilePath;
        this.outputFilePath = outputFilePath;
    }

    public Map<String, Integer> getIndexMap() {
        return indexMap;
    }

    public List<String> getFile() {
        List<String> lines = new ArrayList<>();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath))) {

            byte[] buffer = new byte[2048];
            int character;
            String test = "";

            while ((character = bis.read(buffer)) != -1) {
                lines.add(new String(buffer, 0, character));
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return lines;
    }

    public Map<String, Integer> findKeyWords(List<String> lines) {
        for (String line : lines) {
            String[] tokens = line.split(" ");
            for (String followWord : tokens) {
                if (KeyWords.KEYWORDS.contains(followWord)) {
                    put(followWord);
                }
            }
        }
        return getIndexMap();
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

    public void writeInFile(Map<String, Integer> mapOfKeyWords) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFilePath))) {
            String lineToWrite;

            for (String key : indexMap.keySet()){
                lineToWrite = key + indexMap.get(key);
                bos.write(lineToWrite.getBytes());
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
