package org.jiang.exercise.canvas;

public interface CanvasVisitor {
	default void visit(AsciiCanvas canvas){}
}
