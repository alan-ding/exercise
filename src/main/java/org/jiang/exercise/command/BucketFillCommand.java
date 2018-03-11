package org.jiang.exercise.command;

import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.AsciiCanvas;

public class BucketFillCommand extends DefaultCommand{
	private final int x;
	private final int y;
	private final char toColor;
	public BucketFillCommand(int x, int y,char color) {
		this.x = x;
		this.y = y;
		this.toColor = color;
	}

	@Override
	public void visit(AsciiCanvas canvas) {
		char[][] pixels = canvas.getPixels();
		final char fromColor = pixels[x][y];
		updateColor(fromColor,x,y,canvas.getPixels(),canvas.getWidth(), canvas.getHeight());
	}

	@Override
	protected void validate(Canvas canvas) throws ExecutionException {
		if(canvas==null) throw new ExecutionException("Please create canvas first.");
		outofBounds(canvas,x,y);
	}

	private void updateColor(char fromColor, int pointX, int pointY, char[][] pixels, int width, int height) {
		if(pointX>=0 && pointX<width && pointY>=0 && pointY<height) {
			if(pixels[pointX][pointY]==fromColor) {
				pixels[pointX][pointY]=toColor;
				updateColor(fromColor,pointX-1,pointY,pixels,width,height);
				updateColor(fromColor,pointX+1,pointY,pixels,width,height);
				updateColor(fromColor,pointX,pointY+1,pixels,width,height);
				updateColor(fromColor,pointX,pointY-1,pixels,width,height);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + toColor;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BucketFillCommand other = (BucketFillCommand) obj;
		if (toColor != other.toColor)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
