package org.sherman.finance.candlepattern.filter;

import org.apache.log4j.Logger;
import org.sherman.finance.candlepattern.core.Bar;
import org.sherman.finance.candlepattern.core.BaseFilter;
import org.sherman.finance.candlepattern.util.CloseToOpenBarRange;
import org.sherman.finance.candlepattern.util.Trend;
import org.sherman.finance.candlepattern.util.Trends;


//works only for days
    public class LongTradeDayOfTheWeek extends BaseFilter {
        private final Logger log = Logger.getLogger(LongTradeDayOfTheWeek.class);
        private final int dayOfTheWeek;
        
        public LongTradeDayOfTheWeek(Integer dayOfTheWeek) {
            this.dayOfTheWeek = dayOfTheWeek;
        }

        @Override
        public boolean isAppliedFor(Bar bar) {
            return bar.time.getDayOfWeek() == dayOfTheWeek;
        }

        @Override
        public boolean isSuccess(Bar bar) {
            return Trends.closeToOpenBarRange(bar).isUpTrend();
        }
    }

