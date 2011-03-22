package finance.candlePatterns.test;

import java.io.File;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

import finance.candlePatterns.IO.DataLoader;

public class DataLoaderTest {
    @Test
    public void testFileOpen() {
        DataLoader loader = new DataLoader(new File("non existance file"));
        assertEquals(true, loader.load().isEmpty());
    }
}
