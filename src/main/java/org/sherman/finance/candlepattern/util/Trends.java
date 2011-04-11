package org.sherman.finance.candlepattern.util;

import java.util.List;

import org.sherman.finance.candlepattern.core.Bar;


public class Trends {
    private Trends() {};
    
    public static Trend closeToOpenBarRange(Bar bar) {
        return new CloseToOpenBarRange(bar);
    }
    
    public static Trend closeToOpenRange(List<Bar> bars) {
        return new CloseToOpenRange(bars);
    }
}
