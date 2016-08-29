package se05.task1;

import java.io.File;
import java.util.Scanner;

public class FileManager {
    
    Scanner sc;
    
    private static final String[] columnNames = {"File name","Size","Last modified","Access","Enhanced","Type"};
    private File currentPath;


    public FileManager(File currentPath) {
        this.currentPath = currentPath;
    }
}
