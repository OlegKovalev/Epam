package se02.task2_4.good.property;

public enum PaperSize {
    A0("841×1189"),
    A1("594×841"),
    A2("420×594"),
    A3("297×420"),
    A4("210×297"),
    A5("148×210"),
    A6("105×148");

    private String size;

    PaperSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
