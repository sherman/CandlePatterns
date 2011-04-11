package finance.candlePatterns.Utils;

import java.util.List;

import finance.candlePatterns.Core.Bar;

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
