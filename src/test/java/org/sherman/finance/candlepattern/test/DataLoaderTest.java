package org.sherman.finance.candlepattern.test;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.sherman.finance.candlepattern.io.DataLoader;
import org.sherman.finance.candlepattern.io.FinamDataParser;
import org.sherman.finance.candlepattern.io.FinamParserFactory;
import org.sherman.finance.candlepattern.io.ParserFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;


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
