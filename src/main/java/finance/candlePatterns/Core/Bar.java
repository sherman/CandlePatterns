package finance.candlePatterns.Core;

import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

public class Bar {
    private final LocalDateTime time;
    private final BigDecimal open;
    private final BigDecimal close;
    private final BigDecimal high;
    private final BigDecimal low;
    
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
    
    public LocalDateTime getTime() {
        return time;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }
}
