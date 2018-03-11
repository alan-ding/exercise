package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.CanvasVisitor;

public class QuitCommand implements Command,CanvasVisitor{

	@Override
	public void execute(ExerciseContext context) throws ExecutionException {
		context.setCanvas(null);
		System.out.println("Thanks for using. See you next time.");
		System.exit(0);
	}

}
