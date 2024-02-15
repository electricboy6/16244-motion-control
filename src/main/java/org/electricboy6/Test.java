package org.electricboy6;

import org.electricboy6.internal.MathUtils;
import org.electricboy6.internal.DriveControls;
import org.electricboy6.main.Point2d;
import org.electricboy6.main.Path;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Path path = new Path(new Point2d(-15, 10, 12), new Point2d(10,-30, 90))
                //.setControlPointOne(new Point2d(10, -10))
                //.setControlPointTwo(new Point2d(4, 6))
                .build();
        DriveControls.followPath(path);

        double[][] test = new double[3][3];
        test[0] = new double[]{1, 2, 1};
        test[1] = new double[]{4, 5, 6};
        test[2] = new double[]{7, 8, 9};
        //System.out.println(MathUtils.twoXtwoDeterminate(test));
        System.out.println(MathUtils.threeXthreeDeterminate(test));
        test = MathUtils.inverseOf3x3Matrix(test);
        for(double[] temp : test) {
            for (double temp2 : temp)
                System.out.print(temp2 + ", ");
            System.out.println();
        }
    }
}