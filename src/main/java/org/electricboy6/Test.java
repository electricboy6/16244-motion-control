package org.electricboy6;

import org.electricboy6.internal.DriveControls;
import org.electricboy6.internal.Point2d;
import org.electricboy6.rr.Path;

public class Test {
    public static void main(String[] args) {
        Path path = new Path(new Point2d(-15, 10, 12), new Point2d(10,-30, 90))
                .setControlPointOne(new Point2d(10, -10))
                .setControlPointTwo(new Point2d(4, 6))
                .build();
        DriveControls.followPath(path);
        //Path.crashSystem();
    }
}