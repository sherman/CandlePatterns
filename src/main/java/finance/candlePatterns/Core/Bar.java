package finance.candlePatterns.Core;

import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

public class Bar {
    public final LocalDateTime time;
    public final BigDecimal open;
    public final BigDecimal close;
    public final BigDecimal high;
    public final BigDecimal low;
    
    public Bar(
        LocalDateTime time,
        BigDecimal open,
        BigDecimal close,
        BigDecimal high,
        BigDecimal low
    ) {
        this.time = time;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }
}
