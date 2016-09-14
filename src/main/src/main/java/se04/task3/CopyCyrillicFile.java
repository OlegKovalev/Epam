package se04.task3;

import java.io.*;
import java.util.ArrayList;

public class CopyCyrillicFile {

    private String sourceFilePath;
    private String outputFilePath;

    public CopyCyrillicFile(String sourceFilePath, String outputFilePath) {
        this.sourceFilePath = sourceFilePath;
        this.outputFilePath = outputFilePath;
    }

    public ArrayList<String> readSourceFile() {

        ArrayList<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFilePath), "UTF-8"))) {
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

    public void writeTargetFile(ArrayList<String> lines) {

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-16"))) {
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        } catch (FileNotFoundException exc) {
            System.out.println("File not found!");
        } catch (IOException exc) {
            System.out.println("Write file exception!");
        }
    }
    
    public void copyFile(){
        writeTargetFile(readSourceFile());
    }
}
