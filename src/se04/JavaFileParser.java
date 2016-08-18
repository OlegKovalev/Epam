package se04;

import java.io.*;
import java.util.*;

public class JavaFileParser {


    private Map<String, Integer> indexMap;
    private static final String FILE_PATH = ""; // ./src/se03/task3/HTML_file.html
    private static final byte DELIMITER = (byte) '\n';

    public JavaFileParser() {
        this.indexMap = new HashMap<>();
    }

    public Map<String, Integer> getIndexMap() {
        return indexMap;
    }

    public List<String> getFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {

            ByteArrayOutputStream outString = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int character;

            while ((character = bis.read()) != -1) {
                if (character == DELIMITER) {
                    lines.add(new String(outString.toByteArray()));
                    outString.reset();
                }
                outString.write(buffer, 0, character);
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return lines;
    }

    public Map<String, Integer> findKeyWords(ArrayList<String> lines) {
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
            if (indexMap.get(word) != null) {
                count = indexMap.get(word);
            }
            indexMap.put(word, count++);
        }
    }
}
