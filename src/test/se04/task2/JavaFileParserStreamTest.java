package se04.task2;

import org.junit.Before;
import org.junit.Test;

public class JavaFileParserStreamTest {

    JavaFileParserStream parser;

    @Before
    public void setUp() throws Exception {
        parser = new JavaFileParserStream("./src/se04/resources/task2/FileForExample",
                "./src/se04/resources/task2/OutputFile");
    }

    @Test
    public void findKeyWordsAndWriteInFile() throws Exception {
        parser.findKeyWordsAndWriteInFile();
    }

}