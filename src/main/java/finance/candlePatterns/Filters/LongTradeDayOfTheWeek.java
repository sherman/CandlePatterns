package finance.candlePatterns.Filters;

import org.apache.log4j.Logger;

import finance.candlePatterns.Core.Bar;
import finance.candlePatterns.Core.BaseFilter;
import finance.candlePatterns.Utils.CloseOpenBarRangeTrendDefination;
import finance.candlePatterns.Utils.TrendDefination;

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
            TrendDefination trendChecker = new CloseOpenBarRangeTrendDefination(bar);
            return trendChecker.isUpTrend();
        }
    }

