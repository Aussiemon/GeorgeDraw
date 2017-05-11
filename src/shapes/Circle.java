package shapes;

public class Circle extends Shape {
    private Point left;
    private Point right;
    private Point[] circlePoints;

    public Circle(Point left, Point right,
                     ShapeColor fillColor, ShapeColor strokeColor) {
        super(fillColor, strokeColor);
        this.left = left;
        this.right = right;
    }

    public Circle(Point left, Point right) {
        this(left, right, defaultFillColor, defaultStrokeColor);
    }

    @Override
    public Point[] getPoints() {
        if (circlePoints != null) return circlePoints;
        
        int maxCirclePoints = 999;
        double radius = Math.abs(right.x - left.x);
        double circumfrence = radius * Math.PI;
        double maxSegmentDistance = circumfrence / (double)maxCirclePoints;
        double degreeIncrease = maxSegmentDistance / circumfrence * 360.0;
        double degree = 0;
        double yDelta = 3;
        double xDelta = 3;
        
        Point centerPoint = new Point((int)Math.round(right.x+left.x/2), right.y);
        
        circlePoints = new Point[maxCirclePoints];
        for (int pointIt = 0; pointIt < maxCirclePoints; pointIt++) {
            degree += degreeIncrease;
            yDelta = Math.sin(Math.toRadians(degree)) * radius;
            xDelta = Math.cos(Math.toRadians(degree)) * radius;
            circlePoints[pointIt] = new Point(
                    (int)Math.round(radius
                    - xDelta + left.x),
                    (int)Math.round(centerPoint.y
                    + yDelta));
        }
        return circlePoints;
    }
}
