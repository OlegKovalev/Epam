public class PatternSplitExample {
    public static void main(String[] args) {
        
        String line = "fewbvhewybvweu.";
        String[] tokens = line.split("\\.");
        System.out.print(tokens.length);
    }
}