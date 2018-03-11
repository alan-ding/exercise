package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.AsciiCanvas;

public class CreationCommand extends DefaultCommand{

	private final int width;
	private final int height;
	public CreationCommand(int width, int height) {
		this.width = width;
		this.height = height;
		pixel = ' ';
	}
	
	@Override
	public void execute(ExerciseContext context) throws ExecutionException{
		context.setCanvas(new AsciiCanvas(width,height));
		super.execute(context);		
	}


	@Override
	public void visit(AsciiCanvas canvas) {
		char[][] pixels = canvas.getPixels();
		for(int i = 0;i<width;i++){
			for(int j = 0;j<height;j++){
				pixels[i][j]=pixel;
			}
		}
	}

	
	@Override
	protected void validate(Canvas canvas) throws ExecutionException {
		if(width<=0 || height<=0) throw new ExecutionException("Size of canvas should be greater than zero.");		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
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
		CreationCommand other = (CreationCommand) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
}
