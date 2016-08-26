package se03.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

    private static final Pattern REFERENCE_IMG_PATTERN = Pattern.compile(">([Рр]ис\\.\\s?(\\d+\\.?))");
    private static final Pattern REFERENCE_COMPLETE_IMG_SENTENCE_PATTERN = Pattern.compile(">([Рр]ис\\.\\s?(\\d+).*?\\.)");

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

            line = line.trim();
            line = line.replaceAll("\\(Рис.*\\)", "");

            Matcher matcher = REFERENCE_IMG_PATTERN.matcher(line);

            if (matcher.find()) {
                //this is only for 16th line with pic 
                if (matcher.group(2).contains(".")) {
                    int dotPos = matcher.end(2);
                    line = line.substring(0, dotPos - 1) + line.substring(dotPos);
                }

                matcher = REFERENCE_COMPLETE_IMG_SENTENCE_PATTERN.matcher(line);
                if (matcher.find()) {
                    sourceLines.add(matcher.group(1));
                } else {
                    tempLine = line + " ";
                    isCompleteSentence = false;
                }
            } else {
                if (!isCompleteSentence) {
                    String[] tokens = line.split("\\.");

                    if (tokens[0].equals(line)) {
                        tempLine += line + " ";
                    } else {
                        tempLine += tokens[0];
                        if (!tempLine.endsWith("\\.")) {
                            tempLine += ".";
                        }
                        sourceLines.add(tempLine);
                        tempLine = "";
                        isCompleteSentence = true;
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

        for (String line : lines) {
            line = line.replace("&nbsp;", "");
            line = line.replaceAll("</?[a-z]*>", "");
            convertedSentences.add(line);
        }

        return convertedSentences;
    }
}
