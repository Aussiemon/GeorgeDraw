package shapes;

public class RightTriangle extends Shape {
    private Point topLeft;
    private Point bottomRight;

    public RightTriangle(Point topLeft, Point bottomRight,
                     ShapeColor fillColor, ShapeColor strokeColor) {
        super(fillColor, strokeColor);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public RightTriangle(Point topLeft, Point bottomRight) {
        this(topLeft, bottomRight, defaultFillColor, defaultStrokeColor);
    }

    @Override
    public Point[] getPoints() {
        return new Point[]{
                topLeft,
                topLeft,
                bottomRight,
                new Point(topLeft.x, bottomRight.y)
        };
    }
}
