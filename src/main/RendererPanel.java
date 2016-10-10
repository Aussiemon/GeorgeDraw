package main;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import shapes.Shape;
import shapes.swing.ShapeRenderer;

public class RendererPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private ArrayList<ShapeRenderer> renderers = new ArrayList<>();

	public void addShape(Shape shape) {
		renderers.add(new ShapeRenderer(shape));
		repaint();
	}
	
	public void removeShape(Shape shape) {
		ShapeRenderer targetRenderer = null;
		for (ShapeRenderer renderer : renderers) {
			if (shape == renderer.getShape()) {
				targetRenderer = renderer;
				break;
			}
		}

		if (targetRenderer != null) {
			renderers.remove(targetRenderer);
		}
		repaint();
	}
	
	public void clearShapes() {
		renderers.clear();
		repaint();
	}
	
	public void paintComponent(Graphics graphics) {
		for (ShapeRenderer renderer : renderers) {
			renderer.render(graphics);
		}
	}
}
