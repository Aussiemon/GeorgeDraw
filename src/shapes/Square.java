package shapes;

public class Square extends Rectangle {
	public Square(Point topLeft, int width,
			ShapeColor fillColor, ShapeColor strokeColor) {
		super(topLeft, new Point(topLeft.x + width, topLeft.y + width),
				fillColor, strokeColor);
	}

	public Square(Point topLeft, int width) {
		this(topLeft, width, defaultFillColor, defaultStrokeColor);
	}
}
