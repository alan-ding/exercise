package org.jiang.exercise.command;

import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.AsciiCanvas;

public class LineCommand extends DefaultCommand{
	private final int fromX;
	private final int fromY;
	private final int toX;
	private final int toY;
	
	public LineCommand(int fromX, int fromY, int toX, int toY) {
		super();
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX = toX;
		this.toY = toY;
		pixel = 'x';
	}

	@Override
	public void visit(AsciiCanvas canvas) {
		char[][] pixels = canvas.getPixels();
		for(int x = fromX; x<=toX;x++) {
			for(int y = fromY; y<=toY; y++) {
				pixels[x][y] = pixel;
			}
		}		
	}
	
	@Override
	protected void validate(Canvas canvas) throws ExecutionException {
		if(canvas==null) throw new ExecutionException("Please create canvas first.");
		outofBounds(canvas,fromX,fromY);
		outofBounds(canvas,toX,toY);
		if(fromX>toX || fromY>toY) throw new ExecutionException("A line's fromX/Y should less than toX/Y.");
		if(fromX!=toX && fromY!=toY) throw new ExecutionException("Only Vertical/Horizental line supported.");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fromX;
		result = prime * result + fromY;
		result = prime * result + toX;
		result = prime * result + toY;
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
		LineCommand other = (LineCommand) obj;
		if (fromX != other.fromX)
			return false;
		if (fromY != other.fromY)
			return false;
		if (toX != other.toX)
			return false;
		if (toY != other.toY)
			return false;
		return true;
	}
	
}
