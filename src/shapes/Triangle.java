package shapes;

public class Triangle extends Shape {
    private Point top;
    private Point bottomCenter;

    public Triangle(Point top, Point bottomCenter,
                     ShapeColor fillColor, ShapeColor strokeColor) {
        super(fillColor, strokeColor);
        this.top = top;
        this.bottomCenter = bottomCenter;
    }

    public Triangle(Point top, Point bottomCenter) {
        this(top, bottomCenter, defaultFillColor, defaultStrokeColor);
    }

    @Override
    public Point[] getPoints() {
        return new Point[]{
                new Point(bottomCenter.x, top.y),
                new Point(bottomCenter.x, top.y),
                new Point((int)Math.round(bottomCenter.x/1.5), bottomCenter.y),
                new Point((int)Math.round(bottomCenter.x*1.5), bottomCenter.y)
        };
    }
}
