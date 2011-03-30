package finance.candlePatterns.IO;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.log4j.Logger;
import org.joda.time.LocalDateTime;

import finance.candlePatterns.Core.Bar;

public class FinamDataParser implements DataParser {
    private final String DATA_SPLITTER = ",";
    private final Logger log = Logger.getLogger(FinamDataParser.class);
    
    @Override
    public Bar getBarFromString(String parseString) {
        String[] parts = parseString.split(DATA_SPLITTER);
        
        if (parts.length != 7) {
            log.debug("Strange format: " + parts.length);
            throw new IllegalArgumentException("I don't know such format!");
        }
        
        BigDecimal open = new BigDecimal(parts[2], new MathContext(8));
        BigDecimal high = new BigDecimal(parts[3], new MathContext(8));
        BigDecimal low = new BigDecimal(parts[4], new MathContext(8));
        BigDecimal close = new BigDecimal(parts[5], new MathContext(8));
        
        if (high.intValue() < low.intValue())
            throw new IllegalArgumentException("High must be greater than low!");
        
        Bar bar = new Bar(
            new LocalDateTime(
                new Integer(parts[0].substring(0, 4)),
                new Integer(parts[0].substring(4, 6)),
                new Integer(parts[0].substring(6)),
                new Integer(parts[1].substring(0, 2)),
                new Integer(parts[1].substring(2, 4))
            ),
            open,
            close,
            high,
            low
        );
        
        return bar;
    }
}
