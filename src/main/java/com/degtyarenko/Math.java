package com.degtyarenko;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Math {

    public static final Logger logger = Logger.getLogger(Math.class.getName());

    public double addition(double x, double y) {
        return x + y;
    }

    public double division(double x, double y) {
        if (y == 0) {
            logger.log(Level.INFO, "На ноль делить нельзя");
        } else {
            return x / y;
        }
        return 0;
    }

    public double difference(double x, double y) {
        return x - y;
    }

}
