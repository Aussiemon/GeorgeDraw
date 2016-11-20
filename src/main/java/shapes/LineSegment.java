package shapes;

public class LineSegment extends Shape {
    protected Point startPoint;
    protected Point endPoint;

    public LineSegment(Point startPoint, Point endPoint,
                       ShapeColor fillColor, ShapeColor strokeColor) {
        super(fillColor, strokeColor);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public LineSegment(Point startPoint, Point endPoint) {
        this(startPoint, endPoint, defaultFillColor, defaultStrokeColor);
    }

    @Override
    public Point[] getPoints() {
        Point[] points = {startPoint, endPoint};
        return points;
    }
}
