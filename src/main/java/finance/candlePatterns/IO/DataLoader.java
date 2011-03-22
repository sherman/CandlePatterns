package finance.candlePatterns.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.joda.time.LocalDateTime;

import finance.candlePatterns.Core.Bar;

public class DataLoader {
    private final File dataFile;
    private final Logger log = Logger.getLogger(DataLoader.class);
    
    public DataLoader(File dataFile) {
        this.dataFile = dataFile;
    }

    public File getDataFile() {
        return dataFile;
    }
    
    public Map<LocalDateTime, Bar> load() {
        Map<LocalDateTime, Bar> bars = new HashMap<LocalDateTime, Bar>();
        BufferedReader br = null;
        
        try {
            try {
                br = new BufferedReader(new FileReader(dataFile));
            }  catch (FileNotFoundException e) {
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
        
        
        /*String line;
        
        try {
            while ((line = br.readLine()) != null) {
                //bars.put(key, value)
            }
        } catch (IOException e) {
            
        }
        return bars;*/
    }
}
