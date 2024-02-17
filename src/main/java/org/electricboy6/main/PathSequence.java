package org.electricboy6.main;

import org.electricboy6.internal.PathContinuityException;

import java.util.ArrayList;
import java.util.Objects;

public class PathSequence {
    private ArrayList<Path> paths = new ArrayList<>();
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
}
