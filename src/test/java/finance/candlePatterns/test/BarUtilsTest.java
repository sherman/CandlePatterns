package finance.candlePatterns.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import finance.candlePatterns.Core.Bar;
import finance.candlePatterns.Utils.BarUtils;
import static org.testng.AssertJUnit.*;

public class BarUtilsTest {
    @Test(dataProvider="insideDaysData")
    public void testIsInsideDay(List<Bar> bars, Bar bar, boolean exptected) {
        assertEquals(exptected, BarUtils.isInsideDay(bars, bar));
    }
    
    @DataProvider(name="insideDaysData")
    public Object[][] createInsideDaysData() {
        List<Bar> bars = Arrays.asList(
            new Bar(
                new LocalDateTime("2011-04-22"),
                new BigDecimal(100.00, new MathContext(8)),
                new BigDecimal(200.00, new MathContext(8)),
                new BigDecimal(88.00, new MathContext(8)),
                new BigDecimal(202.00, new MathContext(8))
            ),
            new Bar(
                new LocalDateTime("2011-04-23"),
                new BigDecimal(198.00, new MathContext(8)),
                new BigDecimal(203.00, new MathContext(8)),
                new BigDecimal(203.00, new MathContext(8)),
                new BigDecimal(195.00, new MathContext(8))
            ),
            new Bar(
                new LocalDateTime("2011-04-24"),
                new BigDecimal(202.00, new MathContext(8)),
                new BigDecimal(201.00, new MathContext(8)),
                new BigDecimal(202.00, new MathContext(8)),
                new BigDecimal(198.00, new MathContext(8))
            )
        );
        
        
        return new Object[][] {
            {
                bars,
                new Bar(
                    new LocalDateTime("2011-04-22"),
                    new BigDecimal(100.00, new MathContext(8)),
                    new BigDecimal(200.00, new MathContext(8)),
                    new BigDecimal(88.00, new MathContext(8)),
                    new BigDecimal(202.00, new MathContext(8))
                ),
                false
            },
            {
                bars,
                new Bar(
                    new LocalDateTime("2011-04-23"),
                    new BigDecimal(198.00, new MathContext(8)),
                    new BigDecimal(203.00, new MathContext(8)),
                    new BigDecimal(203.00, new MathContext(8)),
                    new BigDecimal(195.00, new MathContext(8))
                ),
                false,
            },
            {
                bars,
                new Bar(
                    new LocalDateTime("2011-04-24"),
                    new BigDecimal(202.00, new MathContext(8)),
                    new BigDecimal(201.00, new MathContext(8)),
                    new BigDecimal(202.00, new MathContext(8)),
                    new BigDecimal(198.00, new MathContext(8))
                ),
                true
            }
        };
    }
}
