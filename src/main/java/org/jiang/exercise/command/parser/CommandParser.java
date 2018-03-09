package org.jiang.exercise.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jiang.exercise.command.Command;

public abstract class CommandParser {
	
	private final char firstChar;
	private final Pattern pattern;
	
	public CommandParser(char firstChar, Pattern pattern) {
		this.firstChar = firstChar;
		this.pattern = pattern;
	}
	
	/**
	 * @param string
	 * @return the command the string stands for. null if not recognized.
	 */
	public Command parse(String string){
		if(string!=null && string.length()>0 && string.charAt(0)==firstChar){
			Matcher m = pattern.matcher(string);
			if(m.matches()){
				return buildCommand(m);
			}
		}
		return null;
	}

	/**
	 * convert the matching group to the parameters of command
	 * @param m
	 * @return
	 */
  protected abstract Command buildCommand(Matcher m);
}
