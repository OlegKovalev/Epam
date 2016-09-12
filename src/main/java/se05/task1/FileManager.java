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
    private static final Pattern REFERENCE_INPUT_PATTERN = Pattern.compile("([a-zA-Z]+)\\s*([a-zA-Z\\\\.]*)");

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
                System.out.print(currentPath.getAbsolutePath() + "\nEnter command: ");
               /* try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                    tmp = br.readLine();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }*/
             
                
                /*   final String input = "Exit";
                final InputStream stdin = System.in;
                System.setIn(new ByteArrayInputStream(input.getBytes()));

                final Scanner scanner = new Scanner(System.in);
               tmp = scanner.next();

                System.setIn(stdin);
                scanner.close();*/

                matcher = REFERENCE_INPUT_PATTERN.matcher(sc.nextLine());
                if (matcher.find()) {
                    switch (matcher.group(1)) {
                        case "Exit":
                            System.exit(0);
                            break;
                        case "open":
                            if (fileNames.contains(matcher.group(2))) {
                                String tempPath = currentPath.getAbsolutePath() + "\\" + matcher.group(2);
                                currentPath = new File(tempPath);

                                if (currentPath.isFile()) {
                                    readFile().forEach(System.out::println);

                                    System.out.print("Enter sentence for write: ");
                                    writeFile(sc.nextLine());
                                    
                                    getParentPath();
                                } else {
                                    System.out.println("Move to " + tempPath);
                                }
                            } else {
                                System.out.println("File not found!");
                            }
                            break;
                        case "back":
                            getParentPath();
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
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(currentPath), "UTF-8"))) {
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

    private void getParentPath() {
        if (currentPath.getParent() == null) {
            System.out.println("This parent directory.");
        } else {
            currentPath = new File(currentPath.getParent());
        }
    }
     
    /*public String inputReader(InputStreamReader isr){
        try (BufferedReader br = new BufferedReader(isr)) {
            return br.readLine();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return "";
    }*/

}
