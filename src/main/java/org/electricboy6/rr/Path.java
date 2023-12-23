package org.electricboy6.rr;

import org.electricboy6.internal.Point2d;

public class Path {
    private final Point2d startPoint;
    public Path(Point2d start) {
        startPoint = start;
    }
    public Path addWaypoint(Point2d point) {
        return new Path(new Point2d(0,0,0));
    }
    public Path addControlPoint(Point2d point) {
        return new Path(new Point2d(0,0,0));
    }
    public Path build() {
        return new Path(new Point2d(0,0,0));
    }
}
