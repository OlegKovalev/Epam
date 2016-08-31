package se05.task1;

public class HelpOn {
    
    public void printHelp() {
        System.out.println("Possible command:\n" +
                "0. Exit.\n" +
                "1. open [filename/catalog].\n" +
                "2. cd [path].\n" +
                "3. --\n" +
                "4. touch [filename] - Create empty file in current directory;\n" +
                "5. cat [filename] - Print file into console in current directory;\n" +
                "6. rm [filename] - Remove file in current directory;\n" +
                "7. echo [msg] - Display @msg into console. For create file with msg;\n" +
                "8. echo [msg] > [filename] - Record @msg into @filename in current directory;\n" +
                "9. echo [msg] >> [filename] - Append @msg into @filename in current directory;\n" +
                " 10. help - For this message.");
    }
}
