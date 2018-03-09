package org.jiang.exercise.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jiang.exercise.command.Command;
import org.jiang.exercise.command.QuitCommand;

public class QuitCommandParser extends CommandParser{

	
	public QuitCommandParser() {
		super('Q', Pattern.compile("Q\\W+"));
	}

	@Override
	protected Command buildCommand(Matcher m) {
		return new QuitCommand();
	}
	
}
