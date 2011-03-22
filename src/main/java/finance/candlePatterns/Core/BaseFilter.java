package finance.candlePatterns.Core;

import java.util.List;

public abstract class BaseFilter implements BarFilter {
    protected final List<Bar> bars;
    
    public BaseFilter(List<Bar> bars) {
        this.bars = bars;
    }
}
