package org.electricboy6.main;

public class Point2d {
    private final double internalX;
    private final double internalY;
    private final double internalHeading;
    public Point2d(double x, double y, double heading) {
        internalX = x;
        internalY = y;
        internalHeading = heading;
    }
    public Point2d(double x, double y) {
        internalX = x;
        internalY = y;
        internalHeading = 0;
    }
    public Point2d() {
        internalX = 0;
        internalY = 0;
        internalHeading = 0;
    }
    public double getHeading() {
        return internalHeading;
    }
    public double getX() {
        return internalX;
    }
    public double getY() {
        return internalY;
    }
    public Point2d setHeading(double heading) {
        return new Point2d(internalX, internalY, heading);
    }
    public Point2d setX(double x) {
        return new Point2d(x, internalY, internalHeading);
    }
    public Point2d setY(double y) {
        return new Point2d(internalX, y, internalHeading);
    }
    @Override
    public String toString() {
        return getX() + "," + getY() + "," + getHeading();
    }
}
