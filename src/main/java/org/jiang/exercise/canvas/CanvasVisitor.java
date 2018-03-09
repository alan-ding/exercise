package org.jiang.exercise.canvas;

public interface CanvasVisitor {
	default void visit(ConsoleCanvas canvas){}
}
