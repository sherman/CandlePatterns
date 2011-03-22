package finance.candlePatterns.IO;

public interface ParserFactory<T extends DataParser> {
    public T create();
}
