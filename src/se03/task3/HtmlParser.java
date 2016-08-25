package se03.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

    private static final Pattern REFERENCE_IMG_PATTERN = Pattern.compile(">([Рр]ис\\.\\s?(\\d+).*)");
    private static final Pattern REFERENCE_COMPLETE_IMG_SENTENCE_PATTERN = Pattern.compile("(([Рр]ис\\.\\s?(\\d+).*\\.).*)");

    public ArrayList<String> readFile(String fileName) {

        ArrayList<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "CP1251"))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException exc) {
            System.out.println("File not found!");
        } catch (IOException exc) {
            System.out.println("Read file exception!");
        }
        return lines;
    }

    public ArrayList<String> linesWithPic(String fileName) {

        ArrayList<String> lines = readFile(fileName);
        ArrayList<String> sourceLines = new ArrayList<>();
        String tempLine = "";
        boolean isCompleteSentence = true;

        for (String line : lines) {

            Matcher matcher = REFERENCE_IMG_PATTERN.matcher(line);
            
            line = line.trim();
            line = line.replaceAll("\\([Рис].*\\)", ""); 

            if (matcher.find()) {
                matcher = REFERENCE_COMPLETE_IMG_SENTENCE_PATTERN.matcher(line);
                if (matcher.find()) {
                    sourceLines.add(matcher.group(2));
                } else {
                    tempLine = line;
                    isCompleteSentence = false;
                }
            } else {
                //Если это третья строка подряд без точки, то она не заходит в else()...
                if (!isCompleteSentence) {
                    String[] tokens = line.split("\\.");

                    if (tokens.length == 0) {
                        tempLine += line;
                    } else { 
                        if (tokens.length == 1){
                              tempLine += tokens[0];
                        sourceLines.add(tempLine);
                        tempLine = "";
                        isCompleteSentence = true;   
                        }
                   
                    }
                }
            }
        }
        return cleanSentences(sourceLines);
    }
    
    public boolean isSuccessivelyLink(String fileName) {

        Matcher matcher;
        ArrayList<String> lines = linesWithPic(fileName);
        int lastNumberOfImg = Integer.MIN_VALUE;
        int currentNumberOfImg;

        for (String line : lines) {
            matcher = REFERENCE_IMG_PATTERN.matcher(line);

            if (matcher.find()) {
                currentNumberOfImg = Integer.valueOf(matcher.group(2));
                if (currentNumberOfImg >= lastNumberOfImg) {
                    lastNumberOfImg = currentNumberOfImg;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    private ArrayList<String> cleanSentences(ArrayList<String> lines) {
        ArrayList<String> convertedSentences = new ArrayList<>();
        
        for(String line : lines){
            line = line.replaceAll("&nbsp;", "");
            line = line.replaceAll("(<.*>)?", "");
            convertedSentences.add(line);
        }
        
        return convertedSentences;
    }
}
