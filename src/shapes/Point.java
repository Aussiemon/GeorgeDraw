package shapes;

public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double distanceTo(Point target) {
        long xDelta = target.x - x;
        long yDelta = target.y - y;
        return Math.sqrt(xDelta * xDelta + yDelta * yDelta);
    }

    public double angleTo(Point target) {
        long xDelta = target.x - x;
        long yDelta = target.y - y;
        return clampRadians(Math.atan2(yDelta, xDelta));
    }

    public Point pointAtAngle(double angle, double distance) {
        int xDelta = (int) Math.round(Math.cos(angle) * distance);
        int yDelta = (int) Math.round(Math.sin(angle) * distance);
        return new Point(x + xDelta, y + yDelta);
    }

    /**
     * Clamp the angle to [0, 2π). To clamp a value means to
     * prevent it from going outside a particular range. This
     * has special meaning for angles because they are
     * periodic. For example, 90 degrees is the same thing
     * as 360 + 90 degrees (450 degrees). For convenience, we
     * would prefer to work with numbers that are easy to
     * visualize, so we clamp angles to the "first" unit circle.
     *
     * @param angle is the angle to clamp
     * @return the clamped angle
     */
    private double clampRadians(double angle) {
        while (angle < 0) {
            angle += 2 * Math.PI;
        }
        while (angle >= Math.PI * 2) {
            angle -= 2 * Math.PI;
        }
        return angle;
    }
}
