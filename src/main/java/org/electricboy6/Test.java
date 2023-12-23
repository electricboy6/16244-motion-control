package org.electricboy6;

import org.electricboy6.internal.DriveControls;
import org.electricboy6.internal.Point2d;
import org.electricboy6.rr.Path;

public class Test {
    public static void main(String[] args) {
        Path path = new Path(new Point2d(0, 0, 0))
                .addControlPoint(new Point2d(10, 3, 0))
                .build();
        for (double i = 0; i < 1; i+=0.1) {
            System.out.println(DriveControls.accel(10, 0, i));
        }
        System.out.println(10);
        for (double i = 0; i < 1; i+=0.1) {
            System.out.println(DriveControls.decel(0, 10, i));
        }
        System.out.println(0);
    }
}