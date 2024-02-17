package org.electricboy6.main;

public class Constants {
    // Drive constraints
    public static final double MAX_ACCEL = 10; // inches / second / second
    public static final double MAX_ANG_ACCEL = 20; // degrees / second / second
    public static final double MAX_VELOCITY = 40; // set this to about 90% of your robot's capabilities on a lower battery level
    public static final double MAX_ANG_VELOCITY = 180; // degrees / second

    // Path options
    public static final double PATH_COMPUTE_ACCURACY = 1d / 100d;
    // Don't change this unless you need higher path accuracy
    public static final double PATH_LOOKAHEAD_PERCENTAGE = 7.5 / (1 / PATH_COMPUTE_ACCURACY);

    // Robot configuration
    public static final double WHEEL_RADIUS = 96; // normal-sized Gobilda mecanum wheels
    public static final double TRACKING_WHEEL_RADIUS = 48; // Gobilda tracking wheel pods
    public static final double TRACK_WIDTH = 10; // center of wheel to center of wheel, in inches
    public static final double STRAFE_MULTIPLIER = 1.1; // default should be good
    public static final Point2d TRACKING_WHEEL_1 = new Point2d(1, -5, 90); // from center of rotation
    public static final Point2d TRACKING_WHEEL_2 = new Point2d(-2, 5, 0); // same here
}
