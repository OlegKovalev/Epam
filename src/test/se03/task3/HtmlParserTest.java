package se03.task3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlParserTest {
    
    HtmlParser parser;
    String path = "E:\\GitHub\\Epam\\src\\main\\resources\\se03\\task3\\HTML_file.html";
    
    @Before
    public void setUp() throws Exception {
        parser = new HtmlParser();
    }

    @Test
    public void readFileTest() throws Exception {
        
        assertEquals(32, parser.readFileTest(path).size());
    }

    @Test
    public void isSuccessivelyLink() throws Exception {
        
        assertEquals(false, parser.isSuccessivelyLink(path));
    }

}