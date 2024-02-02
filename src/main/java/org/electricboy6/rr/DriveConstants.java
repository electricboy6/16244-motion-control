package org.electricboy6.rr;

import org.electricboy6.internal.Point2d;

public class DriveConstants {
    // Drive constraints
    public static final double INTERPOLATE_FACTOR = 1.05; // this changes the acceleration and deceleration rate. A little goes a long way.
    public static final double MAX_SPEED = 10; // set this to about 90% of your robot's capabilities on a lower battery level

    // Path options
    public static final float PATH_COMPUTE_ACCURACY = 1f / 200f; // increase the larger number to increase the accuracy at the cost of compute time
    // note: the default accuracy is more than enough.

    // Robot configuration
    private static final double WHEEL_RADIUS = 96; // normal-sized Gobilda mecanum wheels
    private static final double TRACKING_WHEEL_RADIUS = 48; // Gobilda tracking wheel pods
    public static final double TRACK_WIDTH = 10; // center of wheel to center of wheel, in inches
    public static final double STRAFE_MULTIPLIER = 1.1; // default should be good
    public static final Point2d TRACKING_WHEEL_1 = new Point2d(1, -5, 90);
    public static final Point2d TRACKING_WHEEL_2 = new Point2d(-2, 5, 0);
}
