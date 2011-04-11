package org.sherman.finance.candlepattern.io;

import org.sherman.finance.candlepattern.core.Bar;

public interface DataParser {
    public Bar getBarFromString(String parseString);
}
