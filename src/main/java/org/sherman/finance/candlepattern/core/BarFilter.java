package org.sherman.finance.candlepattern.core;

import java.util.List;

public interface BarFilter extends FilterResult {
    public void setBars(List<Bar> bars);
    
    public boolean isAppliedFor(Bar bar);
}
