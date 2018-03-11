package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.CanvasVisitor;
import org.jiang.exercise.canvas.AsciiCanvas;

public abstract class DefaultCommand implements Command,CanvasVisitor{

	protected char pixel;
	
	@Override
	public void execute(ExerciseContext context) throws ExecutionException {
		validate(context.getCanvas());
		visit((AsciiCanvas)context.getCanvas());		
	}

	protected abstract void validate(Canvas canvas) throws ExecutionException;
	
	protected void outofBounds(Canvas canvas, int x, int y) throws ExecutionException{
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		if(x<1 || y<1 || x>width || y >height) throw new ExecutionException("Point("+x+","+y+") outofbounds of canvas");
		
	}
}
