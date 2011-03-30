package finance.candlePatterns.test;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.log4j.Logger;
import org.joda.time.LocalDateTime;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import finance.candlePatterns.Core.Bar;
import finance.candlePatterns.IO.FinamDataParser;

import static org.testng.AssertJUnit.*;

public class FinamDataParserTest {
    private final Logger log = Logger.getLogger(DataLoaderTest.class);
    
    @Test(dataProvider="parsingData")
    public void testParse(String parseString, Bar expected) {
        FinamDataParser parser = new FinamDataParser();
        assertBar(expected, parser.getBarFromString(parseString));
    }
    
    @DataProvider(name="parsingData")
    public Object[][] createParsingData() {
        return new Object[][] {
            {
                "20110222,000000,186655.00000,186945.00000,182875.00000,183340.00000,1368923",
                new Bar(
                    new LocalDateTime("2011-02-22"),
                    new BigDecimal(186655.00, new MathContext(8)),
                    new BigDecimal(183340.00, new MathContext(8)),
                    new BigDecimal(186945.00, new MathContext(8)),
                    new BigDecimal(182875.00, new MathContext(8))
                )
            },
            {
                "20110221,180000,186651.00000,186945.00000,182875.00000,183340.00000,1368923",
                new Bar(
                    new LocalDateTime("2011-02-21T18:00:00"),
                    new BigDecimal(186651.00, new MathContext(8)),
                    new BigDecimal(183340.00, new MathContext(8)),
                    new BigDecimal(186945.00, new MathContext(8)),
                    new BigDecimal(182875.00, new MathContext(8))
                )
            }
        };
    }
    
    private void assertBar(
        Bar expected,
        Bar actual
    ) {
        //System.out.println(actual.open.doubleValue());
        assertEquals(expected, actual);
    }
}
