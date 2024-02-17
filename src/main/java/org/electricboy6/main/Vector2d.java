package org.electricboy6.main;

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
}
