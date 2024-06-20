package org.electricboy6.main;

import org.electricboy6.internal.MathUtils;

public class Vector2d {
    private final double internalDirection;
    private final double internalMagnitude;
    public Vector2d(double direction, double magnitude) {
        internalDirection = direction;
        internalMagnitude = magnitude;
    }
    public double getDirection() {
        return this.internalDirection;
    }
    public double getMagnitude() {
        return this.internalMagnitude;
    }
    public Point2d toPoint2d() {
        return MathUtils.vectorToPoint2d(this);
    }
}
