package org.electricboy6;

import org.electricboy6.internal.DriveControls;
import org.electricboy6.internal.Point2d;
import org.electricboy6.rr.Path;

public class Test {
    public static void main(String[] args) {
        Path path = new Path(new Point2d(0, 0, 12), new Point2d(10,-30, 90))
                .addControlPoint(new Point2d(10, 3))
                .addControlPoint(new Point2d(4, 6))
                .addWaypoint(new Point2d(5, 2))
                .build();
        DriveControls.followPath(path);
    }
}