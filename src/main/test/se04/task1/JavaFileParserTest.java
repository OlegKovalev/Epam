package se04.task1;

import org.junit.Before;
import org.junit.Test;

public class JavaFileParserTest {

    JavaFileParser parser;

    @Before
    public void init() throws Exception {
        parser = new JavaFileParser("./src/se04/se04/se05.task1/FileForExample",
                "./src/se04/se04/se05.task1/OutputFile");
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