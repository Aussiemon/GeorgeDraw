package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import shapes.Point;
import shapes.Rectangle;
import shapes.Shape;
import shapes.ShapeColor;
import shapes.Square;

public class Main {
	private static RendererPanel rendererPanel;
	private static Shape activeShape;
	private static Point startPoint;
	private static Point endPoint;
	private static ShapeFactory currentFactory;
	private static ShapeColor currentFillColor = ShapeColor.BLACK;
	private static ShapeColor currentStrokeColor = ShapeColor.BLACK;
	
	private static void setupClearButton(Container pane) {
		JButton clearButton = new JButton("Clear");
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				rendererPanel.clearShapes();
			}
		});
		pane.add(clearButton);
	}
	
	private static void setupStrokeColorMenu(Container pane) {
		JComboBox<ShapeColor> colorMenu = new JComboBox<>();
		for (ShapeColor color : ShapeColor.values()) {
			colorMenu.addItem(color);
		}
		
		colorMenu.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					currentStrokeColor = (ShapeColor) event.getItem();
				}
			}
		});
		
		pane.add(colorMenu);
	}
	
	private static void setupToolMenu(Container pane) {
		JComboBox<ShapeFactory> toolMenu = new JComboBox<>();
		toolMenu.addItem(new ShapeFactory("Rectangle") {
			@Override
			public Rectangle newShape() {
				return new Rectangle(startPoint, endPoint,
						currentFillColor, currentStrokeColor);
			}
		});
		toolMenu.addItem(new ShapeFactory("Square") {
			@Override
			public Square newShape() {
				int width = Math.max(endPoint.x - startPoint.x,
						endPoint.y - startPoint.y);
				return new Square(startPoint, width, currentFillColor,
						currentStrokeColor);
			}
		});
		
		currentFactory = toolMenu.getItemAt(0);
		
		toolMenu.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					currentFactory = (ShapeFactory) event.getItem();
				}
			}
		});
		
		pane.add(toolMenu);
	}
	
	private static void setupButtonBar(Container pane) {
		JPanel buttonBar = new JPanel();
		buttonBar.setLayout(new GridLayout(1, 3));
		
		setupClearButton(buttonBar);
		setupToolMenu(buttonBar);
		setupStrokeColorMenu(buttonBar);
		
		pane.add(buttonBar, BorderLayout.PAGE_START);
	}
	
	private static void setupDrawingArea(Container pane) {
		rendererPanel = new RendererPanel();
		rendererPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				startPoint = new Point(event.getX(), event.getY());
				endPoint = new Point(event.getX(), event.getY());
				activeShape = currentFactory.newShape();
				rendererPanel.addShape(activeShape);
			}
			
			@Override
			public void mouseReleased(MouseEvent event) {
				startPoint = null;
				endPoint = null;
				activeShape = null;
			}
		});
		rendererPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent event) {
				endPoint = new Point(event.getX(), event.getY());
				rendererPanel.removeShape(activeShape);
				activeShape = currentFactory.newShape();
				rendererPanel.addShape(activeShape);
			}
		});
		pane.add(rendererPanel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("George Draw");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setupButtonBar(frame.getContentPane());
		setupDrawingArea(frame.getContentPane());
		
		frame.pack();
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
