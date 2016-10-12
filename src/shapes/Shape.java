package shapes;

public abstract class Shape {
    public static ShapeColor defaultFillColor = ShapeColor.BLACK;
    public static ShapeColor defaultStrokeColor = ShapeColor.BLACK;

    private ShapeColor fillColor;
    private ShapeColor strokeColor;

    public Shape(ShapeColor fillColor, ShapeColor strokeColor) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
    }

    // ----------------
    // Concrete Getters
    // ----------------

    public ShapeColor getFillColor() {
        return fillColor;
    }

    public PointPair[] getPointPairs() {
        Point[] points = getPoints();
        PointPair[] pairs = new PointPair[points.length];

        for (int i = 0; i < points.length; i++) {
            // We set j to i+1 (the next point) except when i references
            // the last element in the array, then we wrap around and
            // set j so that it references the first element in the array.
            int j = i == (points.length - 1) ? 0 : i + 1;
            PointPair pair = new PointPair(points[i], points[j]);
            pairs[i] = pair;
        }

        return pairs;
    }

    public ShapeColor getStrokeColor() {
        return strokeColor;
    }

    // ----------------
    // Abstract methods
    // ----------------

    public abstract Point[] getPoints();
}
