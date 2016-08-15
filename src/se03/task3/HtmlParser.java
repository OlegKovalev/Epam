package se03.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

    private static final Pattern REFERENCE_IMG_PATTERN = Pattern.compile(">([Рр]ис\\.\\s?(\\d+).*)<");

    public ArrayList<String> readFile(String fileName) {

        ArrayList<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException exc) {
            System.out.println("Read file exception!");
        }
        return lines;
    }

    public ArrayList<String> linesWithPic(String fileName) {

        ArrayList<String> lines = readFile(fileName);
        ArrayList<String> sourceLines = new ArrayList<>();

        for (String line : lines) {
            Matcher matcher = REFERENCE_IMG_PATTERN.matcher(line);
            if (matcher.find()) {
                sourceLines.add(line);
            }
        }
        return sourceLines;
    }

    public boolean isSuccessivelyLink(String fileName){

        int temp = Integer.MIN_VALUE;
        ArrayList<String> lines = readFile(fileName);

        for(String line : lines){
            Matcher matcher = REFERENCE_IMG_PATTERN.matcher(line);
            if(Integer.valueOf(matcher.group(2)) >= temp){
                temp = Integer.valueOf(matcher.group(2));
            } else {
                return false;
            }
        }
        return true;
    }
}
