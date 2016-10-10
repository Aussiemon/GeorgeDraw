package shapes.swing;

import java.awt.Color;
import java.awt.Graphics;

import shapes.PointPair;
import shapes.Shape;
import shapes.ShapeColor;

public class ShapeRenderer {
	public static final Color shapeColorToAwtColor(ShapeColor color) {
		switch (color) {
		case BLACK:
			return Color.BLACK;
		case RED:
			return Color.RED;
		case GREEN:
			return Color.GREEN;
		case BLUE:
			return Color.BLUE;
		default:
			return Color.BLACK;
		}
	}
	
	private final Shape shape;
	
	public ShapeRenderer(Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}

	public void render(Graphics graphics) {
		for (PointPair points : shape.getPointPairs()) {
			graphics.setColor(shapeColorToAwtColor(shape.getStrokeColor()));
			graphics.drawLine(points.start.x, points.start.y,
					points.end.x, points.end.y);
		}
	}
}
