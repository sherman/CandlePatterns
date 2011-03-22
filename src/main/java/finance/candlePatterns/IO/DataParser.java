package finance.candlePatterns.IO;

import finance.candlePatterns.Core.Bar;

public interface DataParser {
    public Bar getBarFromString(String parseString);
}
