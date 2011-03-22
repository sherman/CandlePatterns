package finance.candlePatterns.IO;

import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

import finance.candlePatterns.Core.Bar;

public class FinamDataParser implements DataParser {
    private final String DATA_SPLITTER = ",";
    
    @Override
    public Bar getBarFromString(String parseString) {
        String[] parts = parseString.split(DATA_SPLITTER);
        
        if (parts.length != 11)
            throw new IllegalArgumentException("I don't know such format!");
        
        BigDecimal open = new BigDecimal(parts[2]);
        BigDecimal high = new BigDecimal(parts[3]);
        BigDecimal low = new BigDecimal(parts[4]);
        BigDecimal close = new BigDecimal(parts[5]);
        
        if (high.intValue() < low.intValue())
            throw new IllegalArgumentException("High must be greater than low!");
        
        Bar bar = new Bar(
            new LocalDateTime(parts[0]),
            open,
            close,
            high,
            low
        );
        
        return bar;
    }
}
