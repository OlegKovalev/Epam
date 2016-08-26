package se04.task3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Oleg on 20.08.2016.
 */
public class CopyCyrillicFileTest {
    
    CopyCyrillicFile copy;
    String sourcePath = "./src/se04/resources/task3/sourceFile_UTF-8.txt";
    String targetPath = "./src/se04/resources/task3/targetFile_UTF-16.txt";

    @Before
    public void setUp() throws Exception {
        copy = new CopyCyrillicFile(sourcePath, targetPath);
    }

    @Test
    public void readSourceFile() throws Exception {
        
    }

    @Test
    public void writeTargetFile() throws Exception {

    }

    @Test
    public void copyFile() throws Exception {
        copy.copyFile();
    }

}