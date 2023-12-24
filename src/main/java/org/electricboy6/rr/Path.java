package org.electricboy6.rr;

import org.electricboy6.internal.Bezier;
import org.electricboy6.internal.Point2d;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final Point2d startPoint;
    private final Point2d endPoint;
    private List<Point2d> controlPoints = new ArrayList<>();
    private List<Point2d> waypoints = new ArrayList<>();
    public List<Point2d> path = new ArrayList<>();
    public Path(Point2d start, Point2d end) {
        startPoint = start;
        endPoint = end;
    }
    public Path(Point2d start, Point2d end, List<Point2d> controlPointInitializer, List<Point2d> waypointsInitializer) {
        startPoint = start;
        endPoint = end;
        controlPoints = controlPointInitializer;
        waypoints = waypointsInitializer;
    }
    public Path(Point2d start, Point2d end, List<Point2d> controlPointInitializer, List<Point2d> waypointsInitializer, List<Point2d> pathInitializer) {
        startPoint = start;
        endPoint = end;
        controlPoints = controlPointInitializer;
        waypoints = waypointsInitializer;
        path = pathInitializer;
    }

    public Path addControlPoint(Point2d point) {
        controlPoints.add(controlPoints.size(), point);
        return new Path(this.startPoint, this.endPoint, this.controlPoints, this.waypoints);
    }
    public Path build() {
        int j = 0;
        for(double t = 0; t < 1; t+=0.005) {
            path.add(j, Bezier.bezierNew(startPoint, controlPoints.get(0), controlPoints.get(1), endPoint, t).setHeading(lerp(startPoint.getHeading(), endPoint.getHeading(), t)));
            j++;
        }
        path.add(j, endPoint);
        return new Path(startPoint, endPoint, controlPoints, waypoints, path);
    }
    private double lerp(double min, double max, double t) {
        return (min + ((max - min) * t * t));
    }
}
