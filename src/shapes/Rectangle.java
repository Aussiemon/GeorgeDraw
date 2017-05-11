package shapes;

public class Rectangle extends Shape {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight,
                     ShapeColor fillColor, ShapeColor strokeColor) {
        super(fillColor, strokeColor);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Rectangle(Point topLeft, Point bottomRight) {
        this(topLeft, bottomRight, defaultFillColor, defaultStrokeColor);
    }

    @Override
    public Point[] getPoints() {
        return new Point[]{
                topLeft,
                new Point(bottomRight.x, topLeft.y),
                bottomRight,
                new Point(topLeft.x, bottomRight.y)
        };
    }
}
