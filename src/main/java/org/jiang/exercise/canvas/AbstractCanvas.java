package org.jiang.exercise.canvas;

public abstract class AbstractCanvas implements Canvas{
	protected int width;
	protected int height;

	public AbstractCanvas(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}	
	
}
