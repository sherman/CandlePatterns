package finance.candlePatterns.Utils;

import finance.candlePatterns.Core.Bar;

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
