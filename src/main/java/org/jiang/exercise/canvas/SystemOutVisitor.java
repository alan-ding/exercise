package org.jiang.exercise.canvas;

public class SystemOutVisitor implements CanvasVisitor{

	@Override
	public void visit(ConsoleCanvas canvas) {
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		
		char[][] pixels = canvas.getPixels();
		for(int i=-1;i<=width;i++){
			for(int j=-1;j<height+1;j++){
				
			}
		}
	}

}
