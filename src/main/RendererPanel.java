package main;

import shapes.Shape;
import shapes.swing.ShapeRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RendererPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private ArrayList<ShapeRenderer> renderers = new ArrayList<>();

    public void addShape(Shape shape) {
        renderers.add(new ShapeRenderer(shape));
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
    }

    public void clearShapes() {
        renderers.clear();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (ShapeRenderer renderer : renderers) {
            renderer.render(graphics);
        }
    }
}
