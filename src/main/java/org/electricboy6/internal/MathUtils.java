package org.electricboy6.internal;

public class MathUtils {
    public static double twoXtwoDeterminate(double[][] input) {
        if(!(input.length == 2 && input[0].length == 2)) throw new IllegalArgumentException();
        return ((input[0][0] * input[1][1]) - (input[0][1] * input[1][0]));
    }
}
