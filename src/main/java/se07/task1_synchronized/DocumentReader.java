package se07.task1_synchronized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentReader {

    String path;

    public DocumentReader(String path) {
        this.path = path;
    }

    public List<String> readDocument() {
        List<String> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                transactions.add(tempLine);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return transactions;
    }
}
