package ru.appline.sberFramework.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
    private static Logger log;
    private static void initLogger(){
        log = Logger.getLogger("my.logger");
        log.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.ALL);
        log.addHandler(handler);
    }
    public static Logger getLog(){
        if(log == null)
            initLogger();
        return log;
    }
}
