package org.jiang.exercise.command;

import org.jiang.exercise.ExerciseContext;

public interface Command {
	void execute(ExerciseContext context) throws ExecutionException;
}
