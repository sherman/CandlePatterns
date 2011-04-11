package finance.candlePatterns.Utils;

import finance.candlePatterns.Core.Bar;

public class CloseOpenBarRangeTrendDefination implements TrendDefination {
    private final Bar bar;
    
    public CloseOpenBarRangeTrendDefination(Bar bar) {
        this.bar = bar;
    }
    
    @Override
    public boolean isUpTrend() {
        return bar.open.compareTo(bar.close) < 0;
    }
}
