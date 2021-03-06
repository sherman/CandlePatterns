package org.sherman.finance.candlepattern.core;

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
    
    @Override
    public boolean equals(Object that) {
        if (that == this)
            return true;
        
        if (!(that instanceof Bar))
            return false;
        
        final Bar bar = (Bar) that;
        
        return
            bar.time.equals(this.time)
            && bar.open.compareTo(this.open) == 0
            && bar.close.compareTo(this.close) == 0
            && bar.high.compareTo(this.high) == 0
            && bar.low.compareTo(this.low) == 0;
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + time.hashCode();
        hash = hash * 31 + open.hashCode();
        hash = hash * 31 + close.hashCode();
        hash = hash * 31 + high.hashCode();
        return hash * 31 + low.hashCode();
    }
    
    @Override
    public String toString() {
        return String.format("%s %f %f %f %f", time, open, close, high, low);
    }
}
