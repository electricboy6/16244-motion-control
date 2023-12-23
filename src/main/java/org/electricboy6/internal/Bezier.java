package org.electricboy6.internal;

public class Bezier {
    private static Point2d lerp(double x, double y, double w, double z, double t) {
        return new Point2d(
                (x + ((w - x) * t)),
                (y + ((z - y) * t))
        );
    }
    public static Point2d bezier(Point2d startCoord, Point2d endCoord, Point2d control1, Point2d control2, double t) {
        double x1 = startCoord.getX();
        double y1 = startCoord.getY();
        double x2 = control1.getX();
        double y2 = control1.getY();
        double x3 = control2.getX();
        double y3 = control2.getY();
        double x4 = endCoord.getX();
        double y4 = endCoord.getY();
        double nt = 1 - t;
        return new Point2d(
                (((nt * nt * nt * x1) + ((3 * nt * nt) * t * x2)) + (((3 * nt) * t * t * x3) + (t * t * t * x4))),
                (((nt * nt * nt * y1) + ((3 * nt * nt) * t * y2)) + (((3 * nt) * t * t * y3) + (t * t * t * y4)))
        );
    }
    public static Point2d bezierNew(Point2d startPoint, Point2d control1, Point2d control2, Point2d endPoint, double t) {
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