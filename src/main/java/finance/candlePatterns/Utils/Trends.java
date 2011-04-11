package finance.candlePatterns.Utils;

import java.util.List;

import finance.candlePatterns.Core.Bar;

public class Trends {
    private Trends() {};
    
    public static Trend closeToOpenBarRange(Bar bar) {
        return new CloseToOpenBarRange(bar);
    }
    
    public static Trend closeToOpenRange(List<Bar> bars) {
        return new CloseToOpenRange(bars);
    }
}
