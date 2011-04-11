package org.sherman.finance.candlepattern.io;

public class FinamParserFactory<T extends DataParser> implements ParserFactory<FinamDataParser> {
    @Override
    public FinamDataParser create() {
       return new FinamDataParser();
    }
}
