package finance.candlePatterns.Filters;

import org.apache.log4j.Logger;

import finance.candlePatterns.Core.Bar;
import finance.candlePatterns.Core.BaseFilter;

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
            return bar.open.doubleValue() < bar.close.doubleValue();
        }
    }

