package org.sherman.finance.candlepattern;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.sherman.finance.candlepattern.core.Bar;
import org.sherman.finance.candlepattern.core.BarFilter;
import org.sherman.finance.candlepattern.core.FilterApplier;
import org.sherman.finance.candlepattern.io.DataLoader;
import org.sherman.finance.candlepattern.io.FinamDataParser;
import org.sherman.finance.candlepattern.io.FinamParserFactory;
import org.sherman.finance.candlepattern.io.ParserFactory;


/**
 *
 */
public class App {
    private static final Logger log = Logger.getLogger(App.class);
    
    public static void main( String[] args ) {
        FilterCostructor ctor = new FilterCostructor(
            args[0],
            (args.length > 2)
                ? Arrays.copyOfRange(args, 2, args.length)
                : null
        );
        
        BarFilter filter = ctor.createObject();
        
        if (null == filter) {
            log.info("Exit");
            return;
        }
        
        ParserFactory<FinamDataParser> pFactory =
            new FinamParserFactory<FinamDataParser>();
        
        DataLoader<FinamDataParser> loader = new DataLoader<FinamDataParser>(
            new File(args[1]),
            pFactory
        );
        
        List<Bar> bars = loader.load();
        FilterApplier applier = new FilterApplier(filter);
        applier.filtrate(bars);
    }
    
    private static class FilterCostructor {
        private final String filterClassName;
        private final String[] filterArgs;
        
        public FilterCostructor(String filterClassName, String[] filterArgs) {
            this.filterClassName = filterClassName;
            this.filterArgs = filterArgs;
        }
        
        /**
         * @return Constructor and typed args
         */
        public BarFilter createObject() {
            log.debug("Filter class:"  + filterClassName);
            log.debug("Filter args:"  + filterArgs);
            
            // check class
            Class<BarFilter> filterClass = createClass();
            
            if (!BarFilter.class.isAssignableFrom(filterClass)) {
                log.fatal("This class hasn't implemented BarFilter intreface");
                return null;
            }
            
            int filterArgsLength = (null != filterArgs) ? filterArgs.length : 0;
            
            // trying to create class
            Class<?>[] classParams = new Class<?>[filterArgsLength];
            
            Object[] typedArgs = new Object[filterArgsLength];
            
            for (int i = 0; i < filterArgsLength; i++) {
                Integer intValue = getInt(filterArgs[i]);
                
                if (null != intValue) {
                    classParams[i] = intValue.getClass();
                    typedArgs[i] = intValue;
                    continue;
                }
                
                Double doubleValue = getDouble(filterArgs[i]);
                
                if (null != doubleValue) {
                    classParams[i] = doubleValue.getClass();
                    typedArgs[i] = doubleValue;
                    continue;
                }
                
                // string
                classParams[i] = filterArgs[i].getClass();
                typedArgs[i] = filterArgs[i];
            }
            
            Constructor<BarFilter> ctor;
            
            try {
                log.debug(
                    String.format(
                        "Costructor params (%d): %s",
                        classParams.length,
                        classParams
                    )
                );
                
                ctor = filterClass.getConstructor(classParams);
            } catch (SecurityException e) {
                log.fatal(e);
                return null;
            } catch (NoSuchMethodException e) {
                log.fatal(e);
                return null;
            }
            
            
            BarFilter filter = null;
            
            // create filter
            try {
                filter = ctor.newInstance(typedArgs);
            } catch (IllegalArgumentException e) {
                log.fatal(e);
                return null;
            } catch (InstantiationException e) {
                log.fatal(e);
                return null;
            } catch (IllegalAccessException e) {
                log.fatal(e);
                return null;
            } catch (InvocationTargetException e) {
                log.fatal(e);
                return null;
            }
            
            return filter;
        }
        
        private Integer getInt(String arg) {
            try {
                return Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                log.debug("Arg " + arg + " isn't Integer");
                return null;
            }
        }
        
        private Double getDouble(String arg) {
            try {
                return Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                log.debug("Arg " + arg + " isn't Double");
                return null;
            }
        }
        
        @SuppressWarnings("unchecked")
        private Class<BarFilter> createClass() {
            try {
                return (Class<BarFilter>) Class.forName(filterClassName);
            } catch (ClassNotFoundException e) {
                log.fatal(e);
                return null;
            }
        }
    }
}
