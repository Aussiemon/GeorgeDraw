package shapes;

import java.util.ArrayList;
import java.util.Arrays;

public class KochSegment extends LineSegment {
    public KochSegment(Point startPoint, Point endPoint,
                       ShapeColor fillColor, ShapeColor strokeColor) {
        super(startPoint, endPoint, fillColor, strokeColor);
    }

    public KochSegment(Point startPoint, Point endPoint) {
        super(startPoint, endPoint, defaultFillColor, defaultStrokeColor);
    }

    @Override
    public Point[] getPoints() {
        return getPoints(startPoint, endPoint, 3);
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    Point[] getPoints(Point start, Point end, int depth) {
        if (depth < 0) {
            throw new IllegalArgumentException("Depth must be >= 0.");
        }

        if (depth == 0) {
            return new Point[]{end};
        }

        double angle = start.angleTo(end);
        double distance = start.distanceTo(end);

        Point point2 = start.pointAtAngle(angle, distance * 1 / 3);
        Point point3 = point2.pointAtAngle(angle + Math.PI * 1 / 3, distance * 1 / 3);
        Point point4 = start.pointAtAngle(angle, distance * 2 / 3);

        ArrayList<Point> pointsList = new ArrayList<>();
        pointsList.add(start);

        pointsList.addAll(Arrays.asList(getPoints(start, point2, depth -1)));
        pointsList.addAll(Arrays.asList(getPoints(point2, point3, depth -1)));
        pointsList.addAll(Arrays.asList(getPoints(point3, point4, depth -1)));
        pointsList.addAll(Arrays.asList(getPoints(point4, end, depth -1)));

        return pointsList.toArray(new Point[pointsList.size()]);
    }
}
