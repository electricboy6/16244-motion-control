package org.electricboy6.internal;

import org.electricboy6.rr.DriveConstants;
import org.electricboy6.rr.Path;

public class DriveControls {
    private static double interpolate(double min, double max, double range) {
        return (min + ((max - min) * range * (range / DriveConstants.INTERPOLATE_FACTOR)));
    }
    private static double accel(double target, double current, double t) {
        return Math.min(interpolate(current, target, t), DriveConstants.MAX_SPEED);
    }
    private static double decel(double target, double current, double t) {
        return interpolate(current, target, t);
    }
    private static double[] inverseKinematics(double xTarget, double yTarget) {
        double frontLeft = 0;
        double frontRight = 0;
        double rearLeft = 0;
        double rearRight = 0;
        return new double[]{frontLeft, frontRight, rearLeft, rearRight};
    }
    public static void followPath(Path path) {
        System.out.println(path.path);
    }
}
