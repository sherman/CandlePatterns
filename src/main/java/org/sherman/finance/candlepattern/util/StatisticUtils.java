package org.sherman.finance.candlepattern.util;

import org.sherman.finance.candlepattern.core.Bar;

public class StatisticUtils {
    private StatisticUtils() {}
    
    public static String key(Bar bar) {
        return bar.time.getYear() + "_" + bar.time.getMonthOfYear();
    }
}
