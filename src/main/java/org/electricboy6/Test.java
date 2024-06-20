package org.electricboy6;

import org.electricboy6.internal.MathUtils;
import org.electricboy6.internal.DriveControls;
import org.electricboy6.main.PathSequence;
import org.electricboy6.main.Point2d;
import org.electricboy6.main.Path;
import static org.electricboy6.main.Constants.*;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Path path = new Path(new Point2d(-15, 10, 12), new Point2d(10,-30, 90))
                //.setControlPointOne(new Point2d(10, -10))
                //.setControlPointTwo(new Point2d(4, 6))
                .build();
        //DriveControls.followPath(path);

        PathSequence pathSequence = new PathSequence()
                .addPath(new Path(new Point2d(-34, 12, -90), new Point2d(52, -36, 0))
                        .setControlPointOne(new Point2d(3, 10))
                        , true)
                .addPath(new Path(new Point2d(52, -36, 0), new Point2d(60, 50, 90))
                        .setControlPointOne(new Point2d(-20, 10))
                        ,false)
                .build()//;
                .export("/home/colter/IdeaProjects/16244-motion-control/src/main/python/robotPosition.txt");
        DriveControls.followPathSequence(pathSequence);

    }
}