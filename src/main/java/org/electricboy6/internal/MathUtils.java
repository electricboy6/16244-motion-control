package org.electricboy6.internal;

public class MathUtils {
    public static double twoXtwoDeterminate(double[][] input) {
        if(!(input.length == 2 && input[0].length == 2)) throw new IllegalArgumentException();
        return ((input[0][0] * input[1][1]) - (input[0][1] * input[1][0]));
    }
    public static double[][] matrixMultByDouble(double[][] input, double value) {
        for(short i = 0; i < input.length; i++) {
            for (short j = 0; j < input[i].length; j++) {
                input[j][i] *= value;
            }
        }
        return input;
    }
}
