package main;

public class PatternSplitExample {
    public static void main(String[] args) {
        
        String line = "fewbvhewybvweu.vcyewvucevucwetuvcwetu";
        String[] tokens = line.split("\\.");
        System.out.print(tokens.length);
    }
}