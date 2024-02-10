package org.electricboy6.main;

import org.electricboy6.internal.Bezier;

import java.util.ArrayList;
import java.util.List;

import static org.electricboy6.main.Constants.PATH_COMPUTE_ACCURACY;

public class Path {
    private final Point2d startPoint;
    private final Point2d endPoint;
    private List<Point2d> controlPoints = new ArrayList<>();
    {
        controlPoints.add(new Point2d());
        controlPoints.add(new Point2d());
    }
    public List<Point2d> trajectory = new ArrayList<>();
    public Path(Point2d start, Point2d end) {
        startPoint = start;
        endPoint = end;
        controlPoints.set(0, this.startPoint);
        controlPoints.set(1, this.endPoint);
    }
    public Path setControlPointOne(Point2d point) {
        controlPoints.set(0, point);
        return this;
    }
    public Path setControlPointTwo(Point2d point) {
        controlPoints.set(1, point);
        return this;
    }
    public Path build() {
        int j = 0;
        for(double t = 0; t < 1; t += PATH_COMPUTE_ACCURACY) {
            trajectory.add(j, Bezier.bezierNew(this.startPoint, controlPoints.get(0), controlPoints.get(1), this.endPoint, t).setHeading(lerp(startPoint.getHeading(), endPoint.getHeading(), t)));
            j++;
        }
        trajectory.add(j, endPoint);
        return this;
    }
    private double lerp(double min, double max, double t) {
        return (min + ((max - min) * t * t));
    }
}
