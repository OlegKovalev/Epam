package se05.task1;

public class HelpOn {

    public static void printHelp() {
        System.out.println("\nPossible commands:\n" +
                "0. exit\n" +
                "1. open [filename/catalog]\n" +
                "2. back - return to parent directory \n" +
                "3. cd [path] - change directory\n" +
                "4. md [filename] - create new file\n" +
                "5. del [filename] - delete file\n");
    }
}
