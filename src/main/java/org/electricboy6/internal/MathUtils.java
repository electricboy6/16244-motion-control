package org.electricboy6.internal;

import org.electricboy6.main.Vector2d;

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
    public static double[] threeXthreeTimesThreexOne(double[][] threeXthree, double[] threeXone) {
        return new double[]{
                threeXone[0] * threeXthree[0][0] + threeXone[1] * threeXthree[0][1] + threeXone[2] * threeXthree[0][2],
                threeXone[0] * threeXthree[1][0] + threeXone[1] * threeXthree[1][1] + threeXone[2] * threeXthree[1][2],
                threeXone[0] * threeXthree[2][0] + threeXone[1] * threeXthree[2][1] + threeXone[2] * threeXthree[2][2]
        };
    }
    public static double[][] inverseOf3x3Matrix(double[][] input) {
        double[][] output = new double[3][3];

        double determinant = threeXthreeDeterminate(input);
        if(determinant == 0) {
            System.err.println("Matrix cannot be inverted!");
            return null;
        }

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
    public static Vector2d xvelAndYvelToVector(double xvel, double yvel) {
        return new Vector2d(Math.toDegrees(Math.atan2(xvel, yvel)), Math.sqrt((xvel * xvel) + (yvel * yvel)));
    }
    public static double[] vectorToXvelAndYvel(Vector2d input) {
        return new double[]{
                input.getMagnitude() * sin(input.getDirection()),
                input.getMagnitude() * cos(input.getDirection())
        };
    }
    public static double sin(double input) {
        return Math.sin(input);
    }
    public static double cos(double input) {
        return Math.cos(input);
    }
}
