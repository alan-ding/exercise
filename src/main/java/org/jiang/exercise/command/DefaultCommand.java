package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.CanvasVisitor;
import org.jiang.exercise.canvas.ConsoleCanvas;

public abstract class DefaultCommand implements Command,CanvasVisitor{

	@Override
	public void execute(ExerciseContext context) throws Exception {
		Canvas canvas = context.getCanvas();
		if(canvas==null) throw new Exception("Please create canvas first.");
		visit((ConsoleCanvas)context.getCanvas());		
	}
	
}
