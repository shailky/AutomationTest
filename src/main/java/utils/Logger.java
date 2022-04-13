package utils;

import org.slf4j.LoggerFactory;

public class Logger {

    private org.slf4j.Logger logger;

    public Logger(Class klass) {

        logger = LoggerFactory.getLogger(klass);
    }

    public void INFO(Object message) {

        logger.info(message.toString());
    }

    public void ERROR(Object message) {

        logger.error(message.toString());
    }


}
