package org.jiang.exercise.canvas;

public class AsciiCanvas extends AbstractCanvas{
	private final char[][] pixels;
	public AsciiCanvas(int width, int height) {
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
