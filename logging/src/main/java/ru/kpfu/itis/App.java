package ru.kpfu.itis;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    public static void main(String[] args) {
        new App();
    }

    private static final Logger logger = LogManager.getLogger();

    public App(){
        logger.log(Level.TRACE, "Some trace message");
        logger.log(Level.INFO, "Some info message");
        logger.log(Level.ERROR, "Some error message");
        try{
            System.out.println(1/0);
        }
        catch(Throwable e) {
            logger.log(Level.FATAL, "Good idea: to log fatal situations.");
        }
    }
}
