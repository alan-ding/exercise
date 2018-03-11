package org.jiang.exercise.canvas;

/**
 * Define a Canvas for ASCII drawing.<br>
 * However the size of canvas is a bit confusing from the Readme.<br>
 * In the ReadMe, "C 20 4" create a canvas with width of 20 and height of 6. Exclude the border, available space is 18*4.<br>
 * That's a bit of unreasonable. <br>
 * This definition, together with {@link org.jiang.exercise.canvas.SystemOutVisitor SystemOutVisitor} gives a canvas with available space specified in creation command.<br>
 * So "C 20 4" creates a canvas with full dimension of 22*6 with border and available size is <strong>20*4</strong>.
 * @author jiang
 *
 */
public class AsciiCanvas extends AbstractCanvas{
	/**
	 * WARNING: canvas' height and width is <strong>NOT</strong> same with the array's dimension.
	 * Always use {@link org.jiang.exercise.canvas.Canvas#getWidth() getWidth} and {@link org.jiang.exercise.canvas.Canvas#getHeight() getHeight} to get the size of a {@link org.jiang.exercise.canvas.Canvas Canvas}
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
