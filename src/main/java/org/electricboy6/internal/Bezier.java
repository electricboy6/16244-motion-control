package org.electricboy6.internal;

public class Bezier {
    public static Point2d bezier(Point2d startCoord, Point2d endCoord, Point2d control1, Point2d control2, double heading, double t) {
        double x1 = startCoord.getX();
        double y1 = startCoord.getY();
        double x2 = control1.getX();
        double y2 = control1.getY();
        double x3 = control2.getX();
        double y3 = control2.getY();
        double x4 = endCoord.getX();
        double y4 = endCoord.getY();
        double nt = 1 - t;
        return new Point2d(
                (((nt * nt * nt * x1) + ((3 * nt * nt) * t * x2)) + (((3 * nt) * t * t * x3) + (t * t * t * x4))),
                (((nt * nt * nt * y1) + ((3 * nt * nt) * t * y2)) + (((3 * nt) * t * t * y3) + (t * t * t * y4))),
                heading
        );
    }
}