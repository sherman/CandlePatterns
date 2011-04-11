package org.sherman.finance.candlepattern.core;

import java.util.List;

public abstract class BaseFilter implements BarFilter {
    protected List<Bar> bars;
    
    public BaseFilter() {}
    
    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }
}
