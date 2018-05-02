package com.tr.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtil {

    public static Logger initLog(String name) {
        Logger logger = Logger.getLogger(name);
        logger.setLevel(Level.ALL);
        return logger;
    }

}
