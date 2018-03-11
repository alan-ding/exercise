package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.CanvasVisitor;
import org.jiang.exercise.canvas.AsciiCanvas;

public class RectangleCommand extends DefaultCommand{
	
	private final int fromX;
	private final int fromY;
	private final int toX;
	private final int toY;
	
	public RectangleCommand(int x1, int y1, int x2, int y2) {
		this.fromX = x1;
		this.fromY = y1;
		this.toX = x2;
		this.toY = y2;
		pixel = 'x';
	}

	@Override
	public void visit(AsciiCanvas canvas) {
		char[][] pixels = canvas.getPixels();
		for(int w=fromX;w<=toX;w++) {
			pixels[w][fromY]= pixel;
			pixels[w][toY]= pixel;
		}
		for(int h=fromY+1;h<toY;h++) {
			pixels[fromX][h]= pixel;
			pixels[toX][h]= pixel;
		}
	}
	

	@Override
	protected void validate(Canvas canvas) throws ExecutionException {
		if(canvas==null) throw new ExecutionException("Please create canvas first.");
		outofBounds(canvas,fromX,fromY);
		outofBounds(canvas,toX,toY);
		if(fromX>toX || fromY>toY) throw new ExecutionException("A rect's fromX/Y should less than toX/Y.");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fromX;
		result = prime * result + toX;
		result = prime * result + fromY;
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
		RectangleCommand other = (RectangleCommand) obj;
		if (fromX != other.fromX)
			return false;
		if (toX != other.toX)
			return false;
		if (fromY != other.fromY)
			return false;
		if (toY != other.toY)
			return false;
		return true;
	}
	
}
