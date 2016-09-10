package se03.task3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class HtmlParserTest {

    HtmlParser parser;
    String filePath = "./src/main/java/se03/se04/task3/HTML_file.html";

    @Before
    public void setUp() throws Exception {
        parser = new HtmlParser();
    }

    @Test
    public void readFile() throws Exception {
        System.out.println("Lines with pictures:");
        ArrayList<String> lines = parser.readFileTest(filePath);
        lines.forEach(System.out::println);
    }

    /*@Test
    public void readFileTest() throws Exception {
        parser.readFileTest(filePath).forEach(System.out::println);

    }*/

  /*  @Ignore
    @Test
    public void linesWithPic() throws Exception {
        System.out.println("Lines with pictures:");
        ArrayList<String> lines = parser.linesWithPic(filePath);
        lines.forEach(System.out::println);
    }*/

    @Test
    public void isSuccessivelyLink() throws Exception {
        System.out.println("Whether or not successive pictures?");
        System.out.println(parser.isSuccessivelyLink(filePath));

    }

}