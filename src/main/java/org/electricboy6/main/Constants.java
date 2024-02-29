package org.electricboy6.main;

public class Constants {
    // Drive constraints
    public static final double MAX_ACCEL = 10; // inches / second / second
    public static final double MAX_ANG_ACCEL = 20; // degrees / second / second
    public static final double MAX_VELOCITY = 40; // set this to about 90% of your robot's capabilities on a lower battery level
    public static final double MAX_ANG_VELOCITY = 180; // degrees / second

    // Path options
    public static final double PATH_COMPUTE_ACCURACY = 1d / 100d;
    // Don't change this unless told to
    public static final double PATH_LOOKAHEAD_PERCENTAGE = (10d * (1 / PATH_COMPUTE_ACCURACY)) * PATH_COMPUTE_ACCURACY;
    // Changing this changes the amount of the path that is used for calculating the joining path

    // Robot configuration
    public static final double WHEEL_RADIUS = 96; // normal-sized Gobilda mecanum wheels
    public static final double TRACKING_WHEEL_RADIUS = 48; // Gobilda tracking wheel pods
    public static final double TRACK_WIDTH = 10; // center of wheel to center of wheel, in inches
    public static final double WHEELBASE = 20; // center of wheel to center of wheel, in inches
    public static final double STRAFE_MULTIPLIER = 1.1; // default should be good
    public static final Point2d TRACKING_WHEEL_1 = new Point2d(1, -5, 90); // horizontal encoder 1
    public static final Point2d TRACKING_WHEEL_2 = new Point2d(-2, 5, 0); // perpendicular encoder
    public static final Point2d TRACKING_WHEEL_3 = new Point2d(-2, -5, 90); // horizontal encoder 2 (if using 3 wheel, else set it to null)
}
