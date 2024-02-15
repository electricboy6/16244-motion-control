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
    public static double[][] inverseOf3x3Matrix(double[][] input) {
        double[][] output = new double[3][3];

        double determinant = threeXthreeDeterminate(input);

        output[0][0] = ((input[1][1] * input[2][2]) - (input[1][2] * input[2][1]));
        output[0][1] = -((input[0][1] * input[2][2]) - (input[0][2] * input[2][1]));
        output[0][2] = ((input[0][1] * input[1][2]) - (input[0][2] * input[1][1]));

        output[1][0] = -((input[1][0] * input[2][2]) - (input[1][2] * input[2][0]));
        output[1][1] = ((input[0][0] * input[2][2]) - (input[0][2] * input[2][0]));
        output[1][2] = -((input[0][0] * input[1][2]) - (input[0][2] * input[1][0]));

        output[2][0] = ((input[1][0] * input[2][1]) - (input[1][1] * input[2][0]));
        output[2][1] = -((input[0][0] * input[2][1]) - (input[0][1] * input[2][0]));
        output[2][2] = ((input[0][0] * input[1][1]) - (input[0][1] * input[1][0]));

        return matrixMultByDouble(output, 1 / determinant);
    }
    public static double threeXthreeDeterminate(double[][] input) {
        return ((0
                        + (input[0][0] * twoXtwoDeterminate(new double[][]{{input[1][1], input[1][2]}, {input[2][1], input[2][2]}}))
                        - (input[0][1] * twoXtwoDeterminate(new double[][]{{input[1][0], input[1][2]}, {input[2][0], input[2][2]}}))
                        + (input[0][2] * twoXtwoDeterminate(new double[][]{{input[1][0], input[1][1]}, {input[2][0], input[2][1]}}))
                ));
    }
}
