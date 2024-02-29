package org.electricboy6.main;

import org.electricboy6.internal.Logger;
import org.electricboy6.internal.PathContinuityException;
import org.electricboy6.internal.Point2dMath;

import java.util.ArrayList;
import java.util.Objects;

import static org.electricboy6.main.Constants.*;
import static org.electricboy6.internal.Bezier.bezier;
import static org.electricboy6.internal.MathUtils.*;

public class PathSequence {
    private final ArrayList<Path> paths = new ArrayList<>();
    private final ArrayList<Boolean> chaining = new ArrayList<>();
    public ArrayList<Point2d> trajectory = new ArrayList<>();
    public PathSequence() {}
    public PathSequence addPath(Path path, boolean chainWithNext) {
        paths.add(path);
        chaining.add(chainWithNext);
        return this;
    }
    public PathSequence build() {
        for (int i = 0; i < paths.size(); i++) {
            if(!trajectory.isEmpty()) {
                if (!(Objects.equals(paths.get(i).startPoint.toString(), trajectory.get(trajectory.size() - 1).toString())))
                    throw new PathContinuityException(paths.get(i).startPoint + " is not equal to " + trajectory.get(trajectory.size() - 1));
            }
            if(chaining.get(i)) {
                paths.set(i, build(paths.get(i), paths.get(i + 1)));
            } else {
                paths.set(i, paths.get(i).build());
            }
            trajectory.addAll(paths.get(i).trajectory);
        }
        return this;
    }
    public PathSequence export(String filename) {
        Logger logger = new Logger(filename);
        for (Point2d point : this.trajectory) {
            logger.addLine(point.toString());
        }
        return this;
    }
    private Path build(Path path, Path nextPath) {
        ArrayList<Point2d> originalTrajectory = path.build().trajectory;
        ArrayList<Point2d> nextPathOriginalTrajectory = nextPath.build().trajectory;
        ArrayList<Point2d> pathTrajectory = new ArrayList<>();
        int j = 0;
        for(double t = 0; t < 1; t+= PATH_COMPUTE_ACCURACY) {
            if(j < ((1 / PATH_COMPUTE_ACCURACY) - PATH_LOOKAHEAD_PERCENTAGE)) {
                pathTrajectory.add(j, bezier(path.startPoint, path.controlPoints.get(0), path.controlPoints.get(1), path.endPoint, t).setHeading(lerp(path.startPoint.getHeading(), path.endPoint.getHeading(), t)));
            } else {
                pathTrajectory.add(calcJoiningPath(pathTrajectory, t,
                        calcPathVector(originalTrajectory, false),
                        calcPathVector(nextPathOriginalTrajectory, true), nextPath.startPoint));
            }
            j++;
        }
        pathTrajectory.add(path.endPoint);
        path.trajectory = pathTrajectory;
        return path;
    }
    private Point2d calcJoiningPath(ArrayList<Point2d> trajectory, double t, Vector2d thisPath, Vector2d nextPath, Point2d nextPathStart) {
        return bezier(trajectory.get(trajectory.size() - 1),
                Point2dMath.add(vectorToPoint2d(thisPath), trajectory.get(trajectory.size() - 1)),
                Point2dMath.add(vectorToPoint2d(nextPath), nextPathStart), nextPathStart, t);
    }
    private Vector2d calcPathVector(ArrayList<Point2d> trajectory, boolean start) {
        int percentage;
        if(start) {
            percentage = (int) ((PATH_LOOKAHEAD_PERCENTAGE / 100) * (1 / PATH_COMPUTE_ACCURACY));
        } else {
            percentage = (int) ((1 - (PATH_LOOKAHEAD_PERCENTAGE / 100)) * (1 / PATH_COMPUTE_ACCURACY));
        }
        double averageX = 0;
        double averageY = 0;
        int i;
        for(i = 0; i < percentage; i++) {
            averageX += trajectory.get(i + 1).getX() - trajectory.get(i).getX();
            averageY += trajectory.get(i + 1).getY() - trajectory.get(i).getY();
        }
        averageX /= i;
        averageY /= i;
        averageX *= (0.1 / PATH_COMPUTE_ACCURACY);
        averageY *= (0.1 / PATH_COMPUTE_ACCURACY);
        return xvelAndYvelToVector(averageX, averageY);
    }
    private double lerp(double min, double max, double t) {
        return (min + ((max - min) * t * t));
    }
}
