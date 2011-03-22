package finance.candlePatterns.test;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

import finance.candlePatterns.IO.DataLoader;
import finance.candlePatterns.IO.FinamDataParser;
import finance.candlePatterns.IO.FinamParserFactory;
import finance.candlePatterns.IO.ParserFactory;

public class DataLoaderTest {
    private final Logger log = Logger.getLogger(DataLoaderTest.class);
    
    private final ParserFactory<FinamDataParser> pFactory =
        new FinamParserFactory<FinamDataParser>();
    
    @Test
    public void testFileOpen() {
        // test on non existent file
        DataLoader<FinamDataParser> loader = new DataLoader<FinamDataParser>(
            new File("non existent file"),
            pFactory
        );
        assertEquals(true, loader.load().isEmpty());
        
        // test real file
        File testfile = null;
        
        try {
            testfile = File.createTempFile("DataLoader", "test");
        } catch (IOException e) {
            log.error(e);
            return;
        }
        
        loader = new DataLoader<FinamDataParser>(
            testfile,
            pFactory
        );
        assertEquals(true, loader.load().isEmpty());
    }
}
