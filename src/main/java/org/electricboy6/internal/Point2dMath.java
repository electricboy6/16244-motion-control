package org.electricboy6.internal;

import org.electricboy6.main.Point2d;

public class Point2dMath {
    public static Point2d add(Point2d a, Point2d b) {
        return new Point2d(
                a.getX() + b.getX(),
                a.getY() + b.getY(),
                a.getHeading() + b.getHeading()
        );
    }
}
