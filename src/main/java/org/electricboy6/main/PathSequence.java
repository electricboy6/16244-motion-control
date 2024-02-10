package org.electricboy6.main;

import java.util.ArrayList;

public class PathSequence {
    public ArrayList<Path> paths = new ArrayList<>();
    public ArrayList<Point2d> trajectory = new ArrayList<>();
    public PathSequence() {}
    public PathSequence addPath(Path path) {
        paths.add(path);
        return this;
    }
    public PathSequence build() {
        for (Path path : this.paths) {
            path.build();
        }
        return this;
    }
}
