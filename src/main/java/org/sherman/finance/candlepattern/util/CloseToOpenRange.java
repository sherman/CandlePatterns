package org.sherman.finance.candlepattern.util;

import java.util.List;

import org.sherman.finance.candlepattern.core.Bar;


public class CloseToOpenRange implements Trend {
    private final List<Bar> bars;
    
    public CloseToOpenRange(List<Bar> bars) {
        this.bars = bars;
    }
    
    @Override
    public boolean isUpTrend() {
        return bars.get(bars.size() - 1).close.
            subtract(bars.get(0).open).
                doubleValue() > 0;
    }
}
