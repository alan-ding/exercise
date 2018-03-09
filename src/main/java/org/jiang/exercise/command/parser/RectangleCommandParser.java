package org.jiang.exercise.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jiang.exercise.command.Command;
import org.jiang.exercise.command.RectangleCommand;

public class RectangleCommandParser extends CommandParser{

	public RectangleCommandParser() {
		super('R', Pattern.compile("R\\W+(\\d+)\\W+(\\d+)\\W+(\\d+)\\W+(\\d+)"));
	}

	@Override
	protected Command buildCommand(Matcher m) {
		return new RectangleCommand(Integer.parseInt(m.group(1)), 
				 Integer.parseInt(m.group(2)), 
				 Integer.parseInt(m.group(3)), 
				 Integer.parseInt(m.group(4))); 
	}

}
