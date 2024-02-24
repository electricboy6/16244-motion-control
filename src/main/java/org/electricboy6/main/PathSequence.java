package org.electricboy6.main;

import org.electricboy6.internal.Bezier;
import org.electricboy6.internal.PathContinuityException;

import java.util.ArrayList;
import java.util.Objects;

import static org.electricboy6.main.Constants.*;

public class PathSequence {
    private final ArrayList<Path> paths = new ArrayList<>();
    public ArrayList<Point2d> trajectory = new ArrayList<>();
    public PathSequence() {}
    public PathSequence addPath(Path path, boolean chainWithLast) {
        paths.add(path);
        return this;
    }
    public PathSequence build() {
        for (Path path : this.paths) {
            if(!trajectory.isEmpty()) {
                if (!(Objects.equals(path.startPoint.toString(), trajectory.get(trajectory.size() - 1).toString())))
                    throw new PathContinuityException(path.startPoint + " is not equal to " + trajectory.get(trajectory.size() - 1));
            }
            path.build();
            trajectory.addAll(path.trajectory);
        }
        return this;
    }
    public Path build(Path path) {
        ArrayList<Point2d> originalTrajectory = path.build().trajectory;
        ArrayList<Point2d> pathTrajectory = new ArrayList<>();
        int j = 0;
        for(double t = 0; t < 1 / PATH_COMPUTE_ACCURACY; t+= PATH_COMPUTE_ACCURACY) {
            if(t < PATH_LOOKAHEAD_PERCENTAGE) {
                pathTrajectory.add(j, Bezier.bezier(path.startPoint, path.controlPoints.get(0), path.controlPoints.get(1), path.endPoint, t).setHeading(lerp(path.startPoint.getHeading(), path.endPoint.getHeading(), t)));
            } else {

            }
            j++;
        }
        return null;
    }
    private Point2d purePursuit(Point2d currentPoint, ArrayList<Point2d> trajectory) {
        return null;
    }
    private double lerp(double min, double max, double t) {
        return (min + ((max - min) * t * t));
    }
}
