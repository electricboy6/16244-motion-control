package org.electricboy6.main;

public class Constants {
    // Drive constraints
    private static final double MAX_ACCEL = 20; // inches / second
    public static final double MAX_SPEED = 40; // set this to about 90% of your robot's capabilities on a lower battery level

    // Path options
    public static final float PATH_COMPUTE_ACCURACY = 1f / 500f;
    // Don't change this unless you have to

    // Robot configuration
    public static final double WHEEL_RADIUS = 96; // normal-sized Gobilda mecanum wheels
    public static final double TRACKING_WHEEL_RADIUS = 48; // Gobilda tracking wheel pods
    public static final double TRACK_WIDTH = 10; // center of wheel to center of wheel, in inches
    public static final double STRAFE_MULTIPLIER = 1.1; // default should be good
    public static final Point2d TRACKING_WHEEL_1 = new Point2d(1, -5, 90); // from center of rotation
    public static final Point2d TRACKING_WHEEL_2 = new Point2d(-2, 5, 0); // same here
}
