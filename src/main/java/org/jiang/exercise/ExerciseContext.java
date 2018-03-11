package org.jiang.exercise;

import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.CanvasVisitor;
import org.jiang.exercise.canvas.SystemOutVisitor;

public class ExerciseContext {
	private Canvas canvas;
	private final CanvasVisitor printVisitor = new SystemOutVisitor();

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public CanvasVisitor getPrintVisitor() {
		return printVisitor;
	}
}
