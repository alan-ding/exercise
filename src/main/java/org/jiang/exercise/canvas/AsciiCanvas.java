package org.jiang.exercise.canvas;

public class AsciiCanvas extends AbstractCanvas{
	/**
	 * WARNING: canvas' height and width is NOT same with the array's dimension.
	 * Slways use {@link org.jiang.exercise.canvas.Canvas#getWidth() getWidth} and {@link org.jiang.exercise.canvas.Canvas#getHeight() getHeight} to get the size of a {@link org.jiang.exercise.canvas.Canvas Canvas}
	 */
	private final char[][] pixels;
	
	public AsciiCanvas(int width, int height) {
		super(width, height);
		/**
		 * Java index starts with 0, however pixel coordination starts with 1. 
		 */
		pixels = new char[width+1][height+1];
	}

	@Override
	public void acceptVisitor(CanvasVisitor visitor) {
		visitor.visit(this);
	}

	public char[][] getPixels() {
		return pixels;
	}	
	
}
