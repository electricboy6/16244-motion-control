package org.electricboy6.internal;

public class DriveControls {
    private static double interpolate(double min, double max, double range) {
        return (min + ((max - min) * range * (range / 1.05)));
    }
    public static double accel(double target, double current, double t) {
        return interpolate(current, target, t);
    }
    public static double decel(double target, double current, double t) {
        return interpolate(current, target, t);
    }
}
