package se05.task1;

import se05.task1.exception.FileCreateException;

public class FileManagerMain {
    
    public static void main(String[] args) throws FileCreateException {
        FileManager fileManager = new FileManager("O:\\test");
        fileManager.go();
    }
}
