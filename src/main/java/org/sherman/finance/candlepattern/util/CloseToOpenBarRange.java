package org.sherman.finance.candlepattern.util;

import org.sherman.finance.candlepattern.core.Bar;

public class CloseToOpenBarRange implements Trend {
    private final Bar bar;
    
    public CloseToOpenBarRange(Bar bar) {
        this.bar = bar;
    }
    
    @Override
    public boolean isUpTrend() {
        return bar.open.compareTo(bar.close) < 0;
    }
}
