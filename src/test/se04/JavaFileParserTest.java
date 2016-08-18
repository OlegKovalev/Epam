package se04;

import org.junit.Before;
import org.junit.Test;
import se04.task1.JavaFileParser;

import java.util.List;
import java.util.Map;

public class JavaFileParserTest {

    JavaFileParser parser;

    @Before
    public void init() throws Exception {
        parser = new JavaFileParser("./src/se04/task1/resource/FileForExample");
    }

    @Test
    public void getFile() throws Exception {
        List<String> list = parser.getFile();
//        System.out.println("Source file:");
//        list.forEach(System.out::println);
//        if(list.isEmpty()) System.out.println("empty");
    }

    @Test
    public void findKeyWords() throws Exception {
        Map<String, Integer> mapKeyWords = parser.findKeyWords(parser.getFile());

        if (mapKeyWords.isEmpty()) System.out.println("empty");
            for (Map.Entry<String, Integer> pair : mapKeyWords.entrySet()) {
                String key = pair.getKey();
                Object value = pair.getValue();
                System.out.println(key + " " + value);
            }
    }

    @Test
    public void put() throws Exception {

    }

}