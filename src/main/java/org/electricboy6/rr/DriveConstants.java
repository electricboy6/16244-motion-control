package org.electricboy6.rr;

public class DriveConstants {
    // Drive constraints
    public static final double INTERPOLATE_FACTOR = 1.05; // this changes the acceleration and deceleration rate. A little goes a long way.
    public static final double MAX_SPEED = 10; // set this to about 90% of your robot's capabilities on a lower battery level

    // Path options
    public static final float PATH_COMPUTE_ACCURACY = 1f / 100f; // increase the larger number to increase the accuracy at the cost of compute time

    // Robot configuration
    public static final double TRACK_WIDTH = 10; // inches
    public static final double STRAFE_MULTIPLIER = 1.1; // default should be good

}
