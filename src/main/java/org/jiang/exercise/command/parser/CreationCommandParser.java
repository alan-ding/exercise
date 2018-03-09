package org.jiang.exercise.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jiang.exercise.command.Command;
import org.jiang.exercise.command.CreationCommand;

public class CreationCommandParser extends CommandParser{

	public CreationCommandParser() {
		super('C', Pattern.compile("C\\W+(\\d+)\\W+(\\d+)"));
	}

	@Override
	protected Command buildCommand(Matcher m) {
		return new CreationCommand(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
	}

}
