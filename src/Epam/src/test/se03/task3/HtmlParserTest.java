package se03.task3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HtmlParserTest {
    
    HtmlParser parser;
    String path = "E:\\GitHub\\Epam\\src\\main\\resources\\se03\\task3\\HTML_file.html";
    
    @Before
    public void setUp() throws Exception {
        parser = new HtmlParser();
    }

    @Test
    public void readFileTest() throws Exception {
        System.out.println("\nLines with img link:\n");
        parser.readFileTest(path).forEach(System.out::println);
    }

    @Test
    public void isSuccessivelyLink() throws Exception {
        System.out.println("\nSuccessively or not link on img:");
        System.out.print(parser.isSuccessivelyLink(path) + "\n\n");
    }

}