package org.electricboy6.internal;

import org.electricboy6.rr.DriveConstants;
import org.electricboy6.rr.Path;
import org.electricboy6.internal.MathUtils;

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
    private static double[] inverseKinematics(double vf, double vs, double w) {
        /*
         vf denotes the forward velocity of the robot, relative to itself.
         vs denotes the strafe (sideways) velocity of the robot, relative to itself.
         w denotes the rotational velocity of the robot in radians/second (positive means counterclockwise when viewed from above)
        */
        double frontLeft = vf - vs - (DriveConstants.TRACK_WIDTH * w);
        double frontRight = vf + vs + (DriveConstants.TRACK_WIDTH * w);
        double rearLeft = vf + vs - (DriveConstants.TRACK_WIDTH * w);
        double rearRight = vf - vs + (DriveConstants.TRACK_WIDTH * w);
        return new double[]{frontLeft, frontRight, rearLeft, rearRight};
    }
    private static double[] localizationKinematics(double horizontalEncoder, double perpendicularEncoder, double heading) {
        double deltaX = MathUtils.twoXtwoDeterminate(new double[2][2]);
        double deltaY = MathUtils.twoXtwoDeterminate(new double[2][2]);
        double deltaTheta = MathUtils.twoXtwoDeterminate(new double[2][2]);
        return new double[0];
    }
    public static void followPath(Path path) {
        System.out.println(path.path);
    }
}
