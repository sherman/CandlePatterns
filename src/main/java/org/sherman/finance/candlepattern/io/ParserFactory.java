package org.sherman.finance.candlepattern.io;

public interface ParserFactory<T extends DataParser> {
    public T create();
}
