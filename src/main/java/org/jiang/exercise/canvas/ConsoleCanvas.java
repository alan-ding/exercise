package org.jiang.exercise.canvas;

public class ConsoleCanvas extends AbstractCanvas{
	private final char[][] pixels;
	public ConsoleCanvas(int width, int height) {
		super(width, height);
		pixels = new char[width][height];
	}

	@Override
	public void acceptVisitor(CanvasVisitor visitor) {
		visitor.visit(this);
	}

	public char[][] getPixels() {
		return pixels;
	}	
	
}
