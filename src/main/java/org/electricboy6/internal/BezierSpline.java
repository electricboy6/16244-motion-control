package org.electricboy6.internal;

import org.electricboy6.main.Path;
import org.electricboy6.main.Point2d;

import java.util.ArrayList;

public class BezierSpline {
    private final Point2d startPoint;
    private final Point2d endPoint;
    private final Path current;
    private final Path next;
    public ArrayList<Point2d> trajectory;
    private boolean built = false;

    public BezierSpline(Point2d start, Point2d end, Path currentPath, Path endPath) {
        this.startPoint = start;
        this.endPoint = end;
        this.current = currentPath;
        this.next = endPath;
    }
    public BezierSpline build() {
        // convert control point to vector
        // multiply magnitude of vector by -2
        // convert back to point2d
        // use that as control point 1 for spline
        // do the same for the other side
        // use the code for path building to build the bezier spline
        built = true;
        return this;
    }
    public boolean isBuilt() {
        return built;
    }
}