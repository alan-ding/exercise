package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.ConsoleCanvas;

public class CreationCommand extends DefaultCommand{

	private final int width;
	private final int height;
	public CreationCommand(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	
	@Override
	public void execute(ExerciseContext context) throws Exception{
		context.setCanvas(new ConsoleCanvas(width,height));
		super.execute(context);		
	}


	@Override
	public void visit(ConsoleCanvas canvas) {
		char[][] pixels = canvas.getPixels();
		for(int i = 0;i<width;i++){
			for(int j = 0;i<height;j++){
				pixels[i][j]=' ';
			}
		}
	}
	
}
