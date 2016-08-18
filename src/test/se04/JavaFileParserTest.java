package se04;

import org.junit.Before;
import org.junit.Test;
import se04.task1.JavaFileParserStream;

public class JavaFileParserTest {

    JavaFileParserStream parser;

    @Before
    public void init() throws Exception {
        parser = new JavaFileParserStream("./src/se04/task1/resource/FileForExample",
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