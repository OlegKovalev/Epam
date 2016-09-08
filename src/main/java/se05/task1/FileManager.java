package main.java.se05.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

    FileDirectory fileDir;
    Scanner sc;
    private static final Pattern REFERENCE_INPUT_PATTERN = Pattern.compile(".*?([a-zA-Z]+)\\s*([a-zA-Z\\\\]*).*");

    private File currentPath;

    public FileManager(String Path) {
        this.currentPath = new File(Path);
        sc = new Scanner(System.in);
        fileDir = new FileDirectory();
    }

    public void go() {
//        ArrayList<File> files;
        ArrayList<String> fileNames;
        Matcher matcher;
        String tmp = null;
        try {

            while (true) {
                fileDir.printDirectory(currentPath);
                HelpOn.printHelp();
                fileNames = new ArrayList<>(Arrays.asList(currentPath.list()));
                System.out.println("Enter command: ");
                /*
                * Вот после вывода повисает
                * Если убрать ввод, и передать матчеру строку напрямую, то всё работает..
                * Scanner даёт тот же результат
                * */
                try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                    tmp = br.readLine();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
                
                matcher = REFERENCE_INPUT_PATTERN.matcher(tmp);
                if (matcher.find()) {
//            System.out.println(matcher.group(1));
                    switch (matcher.group(1)) {
                        case "Exit":
                            System.exit(0);
                            break;
                        case "open":
                            if (fileNames.contains(matcher.group(2))) {
                                String tempPath = currentPath.getAbsolutePath() + matcher.group(1);
                                currentPath = new File(tempPath);

                                if (currentPath.isFile()) {
                                    readFile().forEach(System.out::println);

                                    System.out.print("Enter sentence for write. Enter dot '.' to finish.");
                                    String writeLine = sc.next();

                                    if (writeLine.contains(".")) {
                                        String[] tokens = writeLine.split("\\.");
                                        writeFile(tokens[0] + ".\n");
                                    }
                                } else {
                                    System.out.println("Move to " + tempPath);
                                }
                            } else {
                                System.out.println("File not found!");
                            }
                            break;
                        case "back":
                            if (currentPath.getParent() == null) {
                                System.out.println("This parent directory.");
                            } else {
                                currentPath = new File(currentPath.getParent());
                            }
                            break;
                        case "cd":

                            break;
                        case "md":

                            break;
                        case "del":

                            break;
                        default:
                            System.out.println("Wrong command!");
                            HelpOn.printHelp();
                            break;
                    }
                }
            }
        } catch (RuntimeException exc) {
            exc.printStackTrace();
        }
    }

    private ArrayList<String> readFile() {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(currentPath))) {
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (java.io.FileNotFoundException exc) {
            System.out.println("File not found");
        } catch (IOException exc) {
            System.out.println("Exception");
        }
        return lines;
    }

    private void writeFile(String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentPath, true))) {

            bw.write(line);
            bw.flush();
        } catch (java.io.FileNotFoundException exc) {
            System.out.println("File not found");
        } catch (IOException exc) {
            System.out.println("Exception");
        }
    }

}
