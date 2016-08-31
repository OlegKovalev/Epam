package se03.task2;

import org.junit.Before;
import org.junit.Test;

import static java.lang.System.out;

public class ResourceBundleAppTest {

    ResourceBundleApp bundle;

    @Before
    public void setUp() throws Exception {
        bundle = new ResourceBundleApp();
    }

    @Test
    public void getBundle() throws Exception {

    }

    @Test
    public void getValue() throws Exception {
        out.println("--------------------------------");
        out.println("line of key3:\n" + bundle.getValue("key3"));

    }

    @Test
    public void getListOfQuestions() throws Exception {
//        out.println("--------------------------------");
//        for(String line : bundle.getListOfQuestions()){
//            out.println(line);
//        }
    }

    @Test
    public void getQuestion() throws Exception {
        out.println("--------------------------------");
        out.println("question 10:\n" + bundle.getQuestion("key10"));
    }

    @Test
    public void getAnswer() throws Exception {
        out.println("--------------------------------");
        out.println("answer on question 10:\n" + bundle.getAnswer("key10"));
    }

    @Test
    public void printListOfQuestions() throws Exception {
        out.println("--------------------------------");
        bundle.printListOfQuestions();
    }

    @Test
    public void changeLocale() throws Exception {
        bundle.changeLocale();
        out.println("--------------------------------");
        out.println("list of questions after change locale:");
        bundle.printListOfQuestions();
    }
}