package org.jiang.exercise.canvas;

public interface Canvas {
	void acceptVisitor(CanvasVisitor visitor);
	public int getWidth();
	public int getHeight() ;
	
}
