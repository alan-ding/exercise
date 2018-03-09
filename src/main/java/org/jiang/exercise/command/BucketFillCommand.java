package org.jiang.exercise.command;

import org.jiang.exercise.canvas.ConsoleCanvas;

public class BucketFillCommand extends DefaultCommand{
	private final int x;
	private final int y;
	public BucketFillCommand(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public void visit(ConsoleCanvas canvas) {
		// TODO Auto-generated method stub
		
	}
	
}
