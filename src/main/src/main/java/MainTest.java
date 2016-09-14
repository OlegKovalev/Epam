public class MainTest {

    public static void main(String[] args) {
        String lineToSplit = "На рисунке 6 показаны короткодействующие силы в неполных магнетонах нейтронов и протонов";
        String tokens[] = lineToSplit.split("[Нн]а рисунке");

        System.out.println(tokens[0] + "\n" + tokens[1]);
    }
}
