package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.CanvasVisitor;

public class LineCommand implements Command,CanvasVisitor{
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
	}

	@Override
	public void execute(ExerciseContext context) throws Exception {
		
	}	
}
