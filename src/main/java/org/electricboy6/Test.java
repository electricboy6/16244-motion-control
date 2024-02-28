package org.electricboy6;

import org.electricboy6.internal.MathUtils;
import org.electricboy6.internal.DriveControls;
import org.electricboy6.main.PathSequence;
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

        PathSequence pathSequence = new PathSequence()
                .addPath(new Path(new Point2d(34, -12, -90), new Point2d(2, 6, 0))
                        .setControlPointOne(new Point2d(23, 54)), false)
                .addPath(new Path(new Point2d(2, 6, 0), new Point2d(20, -6, 90))
                        .setControlPointOne(new Point2d(23, 54)), true)
                .build();
        //DriveControls.followPathSequence(pathSequence);

        double[][] test = new double[3][3];
        double[] test2 = new double[]{1, 2, 3};
        test[0] = new double[]{1, 2, 1};
        test[1] = new double[]{4, 5, 6};
        test[2] = new double[]{7, 8, 9};
        //System.out.println(MathUtils.twoXtwoDeterminate(test));
        System.out.println(MathUtils.threeXthreeDeterminate(test));
        //test = MathUtils.threeXthreeTimesThreexOne(test, test2);
        for(double[] temp : test) {
            for (double temp2 : temp)
                System.out.print(temp2 + ", ");
            System.out.println();
        }
    }
}