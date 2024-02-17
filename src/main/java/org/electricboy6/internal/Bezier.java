package org.electricboy6.internal;

import org.electricboy6.main.Point2d;

public class Bezier {
    private static Point2d lerp(double x, double y, double w, double z, double t) {
        return new Point2d(
                (x + ((w - x) * t)),
                (y + ((z - y) * t))
        );
    }
    public static Point2d bezier(Point2d startPoint, Point2d control1, Point2d control2, Point2d endPoint, double t) {
        Point2d temp;
        double tex;
        double tey;
        double tfx;
        double tfy;
        double tgx;
        double tgy;
        double qhx;
        double qhy;
        double qix;
        double qiy;
        temp = lerp(startPoint.getX(), startPoint.getY(), control1.getX(), control1.getY(), t);
        tex = temp.getX();
        tey = temp.getY();
        temp = lerp(control1.getX(), control1.getY(), control2.getX(), control2.getY(), t);
        tfx = temp.getX();
        tfy = temp.getY();
        temp = lerp(control2.getX(), control2.getY(), endPoint.getX(), endPoint.getY(), t);
        tgx = temp.getX();
        tgy = temp.getY();
        temp = lerp(tex, tey, tfx, tfy, t);
        qhx = temp.getX();
        qhy = temp.getY();
        temp = lerp(tfx, tfy, tgx, tgy, t);
        qix = temp.getX();
        qiy = temp.getY();
        return lerp(qhx, qhy, qix, qiy, t);
    }
}