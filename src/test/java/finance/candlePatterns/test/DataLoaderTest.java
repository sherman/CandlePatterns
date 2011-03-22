package finance.candlePatterns.test;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

import finance.candlePatterns.IO.DataLoader;

public class DataLoaderTest {
    private final Logger log = Logger.getLogger(DataLoaderTest.class);
    
    @Test
    public void testFileOpen() {
        // test on non existent file
        DataLoader loader = new DataLoader(new File("non existent file"));
        assertEquals(true, loader.load().isEmpty());
        
        // test real file
        File testfile = null;
        
        try {
            testfile = File.createTempFile("DataLoader", "test");
        } catch (IOException e) {
            log.error(e);
            return;
        }
        
        loader = new DataLoader(testfile);
        assertEquals(true, loader.load().isEmpty());
    }
}
