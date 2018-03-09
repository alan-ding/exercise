package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.CanvasVisitor;

public class RectangleCommand implements Command,CanvasVisitor{
	private final int x1;
	private final int y1;
	private final int x2;
	private final int y2;
	
	public RectangleCommand(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void execute(ExerciseContext context) {
		
	}
	
}
