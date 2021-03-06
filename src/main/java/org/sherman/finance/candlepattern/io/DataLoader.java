package org.sherman.finance.candlepattern.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import org.apache.log4j.Logger;
import org.sherman.finance.candlepattern.core.Bar;



public class DataLoader<P extends DataParser> {
    private final File dataFile;
    private final Logger log = Logger.getLogger(DataLoader.class);
    private final DataParser parser;
    
    public DataLoader(File dataFile, ParserFactory<P> parserFactory) {
        this.dataFile = dataFile;
        this.parser = parserFactory.create();
    }

    public File getDataFile() {
        return dataFile;
    }
    
    public List<Bar> load() {
        ArrayList<Bar> bars = new ArrayList<Bar>();
        BufferedReader br = null;
        
        try {
            try {
                br = new BufferedReader(new FileReader(dataFile));
                
                String line = null;
                
                while ((line = br.readLine()) != null) {
                    final Bar bar = parser.getBarFromString(line);
                    bars.add(bar);
                }
            } catch (FileNotFoundException e) {
                log.fatal("No suitable file was found.", e);
                return bars;
            } finally {
                if (null != br)
                    br.close();
            }
        } catch (IOException e) {
            log.error(e);
        }
        
        return bars;
    }
}