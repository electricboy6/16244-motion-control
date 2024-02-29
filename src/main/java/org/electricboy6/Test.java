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
        //DriveControls.followPath(path);

        PathSequence pathSequence = new PathSequence()
                .addPath(new Path(new Point2d(-34, -12, -90), new Point2d(2, 6, 0))
                        .setControlPointOne(new Point2d(3, -4))
                        , false)
                .addPath(new Path(new Point2d(2, 6, 0), new Point2d(20, 6, 90))
                        .setControlPointOne(new Point2d(-2, 5))
                        ,false)
                .build()//;
                .export("C:\\Users\\FIRSTUser\\Documents\\FTC\\python\\robotPosition.txt");
        //DriveControls.followPathSequence(pathSequence);

    }
}