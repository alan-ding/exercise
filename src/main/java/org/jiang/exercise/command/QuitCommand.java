package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.CanvasVisitor;

public class QuitCommand implements Command,CanvasVisitor{

	@Override
	public void execute(ExerciseContext context) throws Exception {
		context.setCanvas(null);
		System.exit(0);
	}

}
