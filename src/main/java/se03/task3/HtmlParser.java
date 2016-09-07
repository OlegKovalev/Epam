package se03.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

    private static final Pattern REFERENCE_IMG_PATTERN = Pattern.compile(">([Рр]ис\\.\\s?(\\d+\\.?))");
    private static final Pattern REFERENCE_COMPLETE_IMG_SENTENCE_PATTERN = Pattern.compile(">([Рр]ис\\.\\s?(\\d+).*?\\.)");
    private static final Pattern REFERENCE_IMG_LINK_PATTERN = Pattern.compile("(.*)[Нн]а\\sрисунке\\s\\d+(.*)");
    private static final Pattern REFERENCE_ONE = Pattern.compile("(.*\\.)?(.*[Нн]а\\sрисунке\\s\\d+)((.*\\.)?.*)");

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

    public ArrayList<String> readFileTest(String fileName) {

        ArrayList<String> lines = new ArrayList<>();
        String line;
        String tempLine = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "CP1251"))) {
            while ((line = br.readLine()) != null) {
                line = line.trim();
                line = line.replaceAll("\\(Рис.*\\)", "");
                line = line.replace("&nbsp;", "");
                line = line.replaceAll("</?[a-z\\d]*>", "");

                if (line.contains(".")) {
                    String[] tokens = line.split("\\.");

                    switch (tokens.length) {
                        case 0:
                            break;
                        case 1:
                            tempLine += tokens[0];
                            lines.add(tempLine);
                            tempLine = "";
                            break;
                        case 2:
                            tempLine += tokens[0];
                            lines.add(tempLine);
                            tempLine = tokens[1];
                            break;
                        default:
                            for (String sentence : tokens) {
                                if (sentence.equals(tokens[tokens.length-1])) {
                                    tempLine += sentence + " ";
                                } else {
                                    tempLine += sentence;
                                    lines.add(tempLine);
                                    tempLine = "";
                                }
                            }
                            break;
                    }
                   /* if (tokens[0].equals(line)) {
                        tempLine += line + " ";
//                        lines.add(tempLine);
                    } else {
                        tempLine += tokens[0];
                        if (!tempLine.endsWith("\\.")) {
                            tempLine += ".";
                        }
                        lines.add(tempLine);
                        if (tokens.length > 1) {
                            tempLine = tokens[1];
                        }
                    }*/

                   /* tempLine += tokens[0];
                    lines.add(tempLine);
                    tempLine = tokens[1];
                } else {
                    tempLine += line;
                }*/
//                lines.add(line);
                }
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
        String prevLine = "";
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
                } else {
                    matcher = REFERENCE_IMG_LINK_PATTERN.matcher(line);
                    if (matcher.find()) {

                        if (matcher.group(1) == "") {
                            if (matcher.group(2).contains(".")) {
                                String[] tokens = line.split("\\.");
                                sourceLines.add(tokens[0]);
                            } else {
                                tempLine += line + " ";
                                isCompleteSentence = false;
                            }
                        } else {
                            if (matcher.group(1).contains(".")) {

                            }
                        }
                        /*if (matcher.group(1).contains(".")) {
                            String[] tokens = line.split("\\.");
                            tempLine += tokens[1]
                        }*/
                    }
                }

            }
            prevLine = line;
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
