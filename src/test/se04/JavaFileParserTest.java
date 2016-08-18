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
        parser = new JavaFileParser("./src/se04/task1/resource/FileForExample",
                "./src/se04/task1/resource/OutputFile");
    }

    @Test
    public void getFile() throws Exception {

    }

    @Test
    public void findKeyWords() throws Exception {

    }

    @Test
    public void findKeyWordsAndWriteInFile() throws Exception {
        parser.findKeyWordsAndWriteInFile();
    }


}