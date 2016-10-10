package main;

import shapes.Shape;

public abstract class ShapeFactory {
	private String shapeName;
	
	public ShapeFactory(String shapeName) {
		this.shapeName = shapeName;
	}
	
	@Override
	public String toString() {
		return shapeName;
	}
	
	public abstract Shape newShape();
}
