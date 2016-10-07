package se03.task2;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleApp {

    private final String PATH_TO_PROPERTIES = "se03.task2.question";
    private ResourceBundle bundle;

    public ResourceBundleApp() {
        bundle = ResourceBundle.getBundle(PATH_TO_PROPERTIES, Locale.getDefault());
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public String getValue(String key) {
        if (getBundle().containsKey(key)) {
            return getBundle().getString(key);
        }
        return null;
    }

    public String[] getListOfQuestions() {
        int length = getNumberOfKeys();

        String[] arrayOfKeys = getBundle().keySet().toArray(new String[length]);
        String[] arrayOfQuestions = new String[length];

        for (int i = 0; i < length; i++) {
            arrayOfQuestions[i] = getQuestion(arrayOfKeys[i]);
        }
        return arrayOfQuestions;
    }

    public String getQuestion(String key) {
        String[] parts = getSplitLine(getValue(key));

        if (parts[0].equals(null)) {
            return null;
        }
        return parts[0];
    }

    public String getAnswer(String key) {
        String[] parts = getSplitLine(getValue(key));

        if (parts[1].equals(null)) {
            return "No one knows =`(";
        }
        return parts[1];
    }

    public void printListOfQuestions() {
        int index = 0;

        for (String question : getListOfQuestions()) {
            System.out.println(index + ". " + question);
            index++;
        }
    }

    public void changeLocale() {
        if (getBundle().getLocale().getLanguage().equals(new Locale("ru").getLanguage())) {
            bundle = ResourceBundle.getBundle(PATH_TO_PROPERTIES, new Locale("en"));
            return;
        }
        bundle = ResourceBundle.getBundle(PATH_TO_PROPERTIES, new Locale("ru"));

    }

    private int getNumberOfKeys() {
        return getBundle().keySet().size();
    }

    private String[] getSplitLine(String line) {
        String[] parts = line.split("/");

        if (!(parts[0].isEmpty() || parts[1].isEmpty())) {
            return parts;
        }
        return null;
    }
}
