package org.jiang.exercise.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jiang.exercise.command.Command;
import org.jiang.exercise.command.BucketFillCommand;

public class BucketFillCommandParser extends CommandParser{

	public BucketFillCommandParser() {
		super('B', Pattern.compile("B\\W+(\\d+)\\W+(\\d+)\\W+(\\w)"));
	}

	@Override
	protected Command buildCommand(Matcher m) {
		return new BucketFillCommand(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)),m.group(3).charAt(0));
	}

}
