package org.electricboy6.rr;

import org.electricboy6.internal.Bezier;
import org.electricboy6.internal.Point2d;

import java.util.ArrayList;
import java.util.List;

import static org.electricboy6.rr.Constants.PATH_COMPUTE_ACCURACY;

public class Path {
    private final Point2d startPoint;
    private final Point2d endPoint;
    private List<Point2d> controlPoints = new ArrayList<>();
    {
        controlPoints.add(new Point2d());
        controlPoints.add(new Point2d());
    }
    public List<Point2d> path = new ArrayList<>();
    public Path(Point2d start, Point2d end) {
        startPoint = start;
        endPoint = end;
    }
    public Path(Point2d start, Point2d end, List<Point2d> controlPointInitializer) {
        startPoint = start;
        endPoint = end;
        controlPoints = controlPointInitializer;
    }
    public Path(Point2d start, Point2d end, List<Point2d> controlPointInitializer, List<Point2d> pathInitializer) {
        startPoint = start;
        endPoint = end;
        controlPoints = controlPointInitializer;
        path = pathInitializer;
    }
    public Path setControlPointOne(Point2d point) {
        controlPoints.set(0, point);
        //return new Path(this.startPoint, this.endPoint, this.controlPoints);
        return this;
    }
    public Path setControlPointTwo(Point2d point) {
        controlPoints.set(1, point);
        //return new Path(this.startPoint, this.endPoint, this.controlPoints);
        return this;
    }
    public Path initializeControlPoints() {
        controlPoints.set(0, this.startPoint);
        controlPoints.set(1, this.endPoint);
        //return new Path(this.startPoint, this.endPoint, this.controlPoints);
        return this;
    }
    public Path build() {
        int j = 0;
        for(double t = 0; t < 1; t += PATH_COMPUTE_ACCURACY) {
            path.add(j, Bezier.bezierNew(this.startPoint, controlPoints.get(0), controlPoints.get(1), this.endPoint, t).setHeading(lerp(startPoint.getHeading(), endPoint.getHeading(), t)));
            j++;
        }
        path.add(j, endPoint);
        //return new Path(this.startPoint, this.endPoint, this.controlPoints, path);
        return this;
    }
    private double lerp(double min, double max, double t) {
        return (min + ((max - min) * t * t));
    }
}
