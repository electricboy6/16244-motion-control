package org.electricboy6.internal;

import org.electricboy6.main.Path;
import org.electricboy6.main.PathSequence;

import static org.electricboy6.internal.MathUtils.twoXtwoDeterminate;
import static org.electricboy6.internal.MathUtils.sin;
import static org.electricboy6.internal.MathUtils.cos;
import static org.electricboy6.main.Constants.*;

public class DriveControls {
    private static double interpolate(double min, double max, double range) {
        return (min + ((max - min) * range));
    }
    private static double decel(double target, double current, double t) {
        return interpolate(current, target, t);
    }
    private static double[] inverseKinematics(double vf, double vs, double w) {
        /*
         vf denotes the forward velocity of the robot
         vs denotes the strafe (sideways) velocity of the robot
         w denotes the rotational velocity of the robot in radians/second (positive means counterclockwise when viewed from above)
        */
        double frontLeft = vf - vs - (TRACK_WIDTH * w);
        double frontRight = vf + vs + (TRACK_WIDTH * w);
        double rearLeft = vf + vs - (TRACK_WIDTH * w);
        double rearRight = vf - vs + (TRACK_WIDTH * w);
        return new double[]{frontLeft, frontRight, rearLeft, rearRight};
    }
    private static double[] twoWheelEncoderKinematics(double horizontalEncoder, double perpendicularEncoder, double heading) {
        double wheel1x = TRACKING_WHEEL_1.getX();
        double wheel1y = TRACKING_WHEEL_1.getY();
        double wheel1heading = TRACKING_WHEEL_1.getHeading();
        double wheel2x = TRACKING_WHEEL_2.getX();
        double wheel2y = TRACKING_WHEEL_2.getY();
        double wheel2heading = TRACKING_WHEEL_2.getHeading();

        double[] input = new double[]{horizontalEncoder, perpendicularEncoder, heading};

        double[][] systemOfEquasions = new double[3][3];
        systemOfEquasions[0] = new double[]{cos(wheel1heading), sin(wheel1heading), (wheel1x * sin(wheel1heading)) - (wheel1y * cos(wheel1heading))};
        systemOfEquasions[1] = new double[]{cos(wheel2heading), sin(wheel2heading), (wheel2x * sin(wheel2heading)) - (wheel2y * cos(wheel2heading))};
        systemOfEquasions[2] = new double[]{0, 0, WHEEL_RADIUS};

        double[][] invertedMatrix = MathUtils.inverseOf3x3Matrix(systemOfEquasions);

        assert invertedMatrix != null;
        double[] multipliedMatrix = MathUtils.threeXthreeTimesThreexOne(invertedMatrix, input);

        double deltaX = twoXtwoDeterminate(new double[2][2]);
        double deltaY = twoXtwoDeterminate(new double[2][2]);
        double deltaTheta = twoXtwoDeterminate(new double[2][2]);
        return new double[]{deltaX, deltaY, deltaTheta};
    }
    public static void followPath(Path path) {
        System.out.println(path.trajectory);
    }
    public static void followPathSequence(PathSequence path) {
        System.out.println(path.trajectory);
    }
}
