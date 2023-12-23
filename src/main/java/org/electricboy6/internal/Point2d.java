package org.electricboy6.internal;

public class Point2d {
    private static double internalX;
    private static double internalY;
    private static double internalHeading;
    public Point2d(double x, double y, double heading) {
        internalX = x;
        internalY = y;
        internalHeading = heading;
    }
    public double getHeading() {return internalHeading;}
    public double getX() {return internalX;}
    public double getY() {return internalY;}
}
