package org.electricboy6.internal;

import org.electricboy6.main.Path;
import org.electricboy6.main.Point2d;
import org.electricboy6.main.Vector2d;

import java.util.ArrayList;

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
    public static Point2d vectorToPoint2d(Vector2d input) {
        return new Point2d(
                input.getMagnitude() * sin(input.getDirection()),
                input.getMagnitude() * cos(input.getDirection())
        );
    }
    public static double sin(double input) {
        return Math.sin(input);
    }
    public static double cos(double input) {
        return Math.cos(input);
    }
    public static double movingAverage(double[] input, int startPos, int windowSize) {
        double output = 0;
        for(int i = startPos; i < startPos + windowSize; i++) {
            output += input[i];
        }
        output /= windowSize;
        return output;
    }
    /*
    * first derivative: slope of y / slope of x (using t in place of the bottom part of the slope formula)
    * second derivative: slope of first derivative / slope of x
    * */
    public static double derivativeAtPointOfPath(Path targetPath, double targetT, double otherT) {
        Point2d targetPoint = targetPath.calculateBezierPoint(targetT);
        Point2d otherPoint = targetPath.calculateBezierPoint(otherT);
        double y1 = targetPoint.getY();
        double y2 = otherPoint.getY();
        double x1 = targetPoint.getX();
        double x2 = otherPoint.getX();
        double ySlope = slope(new Point2d(targetT, y1), new Point2d(targetT, y2));
        double xSlope = slope(new Point2d(targetT, x1), new Point2d(targetT, x2));
        return ySlope / xSlope;
    }
    public static double derivativeAtPointOfPath(Path targetPath, double targetT) {
        double otherT;
        if(targetT > 0.999) {
            otherT = targetT - 0.01;
        } else {
            otherT = targetT + 0.01;
        }
        return derivativeAtPointOfPath(targetPath, targetT, otherT);
    }
    public static double secondDerivativeAtPointOfPath(Path targetPath, double targetT) {
        double otherT;
        double otherOtherT;
        if(targetT > 0.999) {
            otherT = targetT - 0.01;
            otherOtherT = otherT - 0.01;
        } else {
            otherT = targetT + 0.01;
            otherOtherT = otherT + 0.01;
        }
        Point2d targetPoint = targetPath.calculateBezierPoint(targetT);
        Point2d otherPoint = targetPath.calculateBezierPoint(otherT);
        double y1 = targetPoint.getY();
        double y2 = otherPoint.getY();
        double x1 = targetPoint.getX();
        double x2 = otherPoint.getX();
        double ySlope = slope(new Point2d(targetT, y1), new Point2d(targetT, y2));
        double xSlope = slope(new Point2d(targetT, x1), new Point2d(targetT, x2));
        double firstDerivative = ySlope / xSlope;
        double otherDerivative = derivativeAtPointOfPath(targetPath, targetT, otherOtherT);
        double derivativeSlope = slope(new Point2d(targetT, firstDerivative), new Point2d(otherT, otherDerivative));
        return derivativeSlope / xSlope;
    }
    private static double slope(Point2d point1, Point2d point2) {
        return (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
    }
}
