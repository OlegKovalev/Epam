package se05.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

    FileDirectory fileDir;
    Scanner sc;
    private static final Pattern REFERENCE_INPUT_PATTERN = Pattern.compile("([a-zA-Z]+)\\s*([a-zA-Z\\\\.:]*)");

    private File currentPath;

    public FileManager(String path) {
        try {
            this.currentPath = new File(path);
        } catch (NullPointerException exc) {
            throw new NullPointerException("File path is null!");
        }
        if (!currentPath.exists()) {
            throw new NullPointerException("Wrong path!");
        }
        sc = new Scanner(System.in);
        fileDir = new FileDirectory();
    }

    public void go() {
        ArrayList<String> fileNames;
        Matcher matcher;
        String tmp = null;
        try {
            while (true) {
                fileDir.printDirectory(currentPath);
                HelpOn.printHelp();

                fileNames = new ArrayList<>(Arrays.asList(currentPath.list()));
                printLine(currentPath.getAbsolutePath() + "\nEnter command: ");

                matcher = REFERENCE_INPUT_PATTERN.matcher(sc.nextLine());
                if (matcher.find()) {
                    switch (matcher.group(1)) {
                        case "exit":
                            System.exit(0);
                            break;
                        case "open":
                            if (fileNames.contains(matcher.group(2))) {
                                String tempPath = currentPath.getAbsolutePath() + "\\" + matcher.group(2);
                                currentPath = new File(tempPath);

                                if (currentPath.isFile()) {
                                    readFile().forEach(System.out::println);

                                    printLine("Enter sentence for write: ");
                                    writeFile(sc.nextLine());

                                    getParentPath();
                                } else {
                                    printLine("Move to " + tempPath);
                                }
                            } else {
                                printLine("File not found!");
                            }
                            break;
                        case "back":
                            getParentPath();
                            break;
                        case "cd":
                            currentPath = new File(matcher.group(2));
                            break;
                        case "md":
                            try {
                                File newFile = new File(currentPath.getAbsolutePath() + "\\" + matcher.group(2));
                                if (newFile.createNewFile()) {
                                    printLine("New file " + matcher.group(2) + " was created.");
                                }
                            } catch (IOException exc) {
                                printLine("IOException!");
                            }
                            break;
                        case "del":
                            try {
                                File delFile = new File(currentPath.getAbsolutePath() + "\\" + matcher.group(2));
                                if (delFile.delete()) {
                                    printLine("File " + matcher.group(2) + " was deleted.");
                                }
                            } catch (SecurityException exc) {
                                printLine("File cant't be deleted!");
                            }
                            break;
                        default:
                            printLine("Wrong command!");
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
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(currentPath), "UTF-8"))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException exc) {
            printLine("File not found!");
        } catch (IOException exc) {
            printLine("Read file exception!");
        }
        return lines;
    }

    private void writeFile(String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentPath, true))) {
            bw.write(line + "\n");
            bw.flush();
        } catch (FileNotFoundException exc) {
            printLine("File not found");
        } catch (IOException exc) {
            printLine("Exception");
        }
    }

    private void getParentPath() {
        if (currentPath.getParent() == null) {
            printLine("This parent directory.");
        } else {
            currentPath = new File(currentPath.getParent());
        }
    }

    private void printLine(String line) {
        System.out.println(line);
    }
}
