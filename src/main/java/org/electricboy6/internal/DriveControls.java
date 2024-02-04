package org.electricboy6.internal;

import org.electricboy6.rr.Constants;
import org.electricboy6.rr.Path;

import static org.electricboy6.rr.Constants.TRACK_WIDTH;
import static org.electricboy6.rr.Constants.TRACKING_WHEEL_1;
import static org.electricboy6.rr.Constants.TRACKING_WHEEL_2;

import static org.electricboy6.internal.MathUtils.twoXtwoDeterminate;

public class DriveControls {
    private static double interpolate(double min, double max, double range) {
        return (min + ((max - min) * range * (range / Constants.INTERPOLATE_FACTOR)));
    }
    private static double accel(double target, double current, double t) {
        return Math.min(interpolate(current, target, t), Constants.MAX_SPEED);
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
        double frontLeft = vf - vs - (TRACK_WIDTH * w);
        double frontRight = vf + vs + (TRACK_WIDTH * w);
        double rearLeft = vf + vs - (TRACK_WIDTH * w);
        double rearRight = vf - vs + (TRACK_WIDTH * w);
        return new double[]{frontLeft, frontRight, rearLeft, rearRight};
    }
    private static double[] encoderKinematics(double horizontalEncoder, double perpendicularEncoder, double heading) {
        double wheel1x = TRACKING_WHEEL_1.getX();
        double wheel1y = TRACKING_WHEEL_1.getY();
        double wheel1heading = TRACKING_WHEEL_1.getHeading();
        double wheel2x = TRACKING_WHEEL_2.getX();
        double wheel2y = TRACKING_WHEEL_2.getY();
        double wheel2heading = TRACKING_WHEEL_2.getHeading();

        double deltaX = twoXtwoDeterminate(new double[2][2]);
        double deltaY = twoXtwoDeterminate(new double[2][2]);
        double deltaTheta = twoXtwoDeterminate(new double[2][2]);
        return new double[]{deltaX, deltaY, deltaTheta};
    }
    public static void followPath(Path path) {
        System.out.println(path.path);
    }
}
