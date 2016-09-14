package se03.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

    private static final Pattern REFERENCE_RU_LANGUAGE_PATTERN = Pattern.compile(".*[А-я].*");
    private static final Pattern REFERENCE_SENTENCE_PATTERN = Pattern.compile("(.*?[^Рис][А-я|)|>|»|0-9|\\s][.|!|?])([\\sА-Я<].*)?");
    private static final Pattern REFERENCE_IMG_LINK_PATTERN = Pattern.compile(".*[Нн]а\\sрисунке\\s(\\d+).*");


    public ArrayList<String> readFileTest(String fileName) {

        ArrayList<String> lines = new ArrayList<>();
        Matcher matcherSentence;
        String line;
        String tempLine = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "CP1251"))) {
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\\([Рр]ис.\\s?\\d+\\)", "");
                line = line.replace("&nbsp;", "");
                line = line.replaceAll("<.*?>", "");
                line = line.trim();

                if (REFERENCE_RU_LANGUAGE_PATTERN.matcher(line).find()) {
                    matcherSentence = REFERENCE_SENTENCE_PATTERN.matcher(line);

                    if (matcherSentence.find()) {
                        tempLine += matcherSentence.group(1);
                        if (REFERENCE_IMG_LINK_PATTERN.matcher(tempLine).find()) {
                            lines.add(clearSentence(tempLine));
                        }
                        tempLine = matcherSentence.group(2);
                        if (tempLine != null) {

                            if (REFERENCE_SENTENCE_PATTERN.matcher(tempLine).find() && REFERENCE_IMG_LINK_PATTERN.matcher(tempLine).find()) {
                                String[] sentences = tempLine.split("[.|!|?]");
                                int tokensCount = sentences.length;
                                if (tokensCount == 1) {
                                    lines.add(clearSentence(sentences[0]));
                                } else {
                                    for (int i = 0; i < tokensCount; i++) {
                                        if (sentences[i].contains("а рисунке")) {
                                            lines.add(clearSentence(sentences[i]));
                                        }
                                    }
                                }
                            }
                        }
                        tempLine = "";
                    }
                }
            }
        } catch (FileNotFoundException exc) {
            System.out.println("File not found!");
        } catch (IOException exc) {
            System.out.println("Read file exception!");
        }
        return lines;
    }

    public boolean isSuccessivelyLink(String fileName) {

        Matcher matcher;
        ArrayList<String> lines = readFileTest(fileName);
        int lastNumberOfImg = Integer.MIN_VALUE;
        int currentNumberOfImg;

        for (String line : lines) {
            matcher = REFERENCE_IMG_LINK_PATTERN.matcher(line);

            if (matcher.find()) {
                currentNumberOfImg = Integer.valueOf(matcher.group(1));
                if (currentNumberOfImg >= lastNumberOfImg) {
                    lastNumberOfImg = currentNumberOfImg;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private String clearSentence(String sentence) {
        sentence = sentence.replaceAll("null", "");
        sentence = sentence.trim();
        if (!sentence.endsWith(".")) {
            sentence += ".";
        }
        sentence += "\n";
        return sentence;
    }
}