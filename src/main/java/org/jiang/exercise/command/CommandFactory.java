package org.jiang.exercise.command;

import org.jiang.exercise.command.parser.BucketFillCommandParser;
import org.jiang.exercise.command.parser.CommandParser;
import org.jiang.exercise.command.parser.CreationCommandParser;
import org.jiang.exercise.command.parser.LineCommandParser;
import org.jiang.exercise.command.parser.QuitCommandParser;
import org.jiang.exercise.command.parser.RectangleCommandParser;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

public class CommandFactory {
	
	private static final CommandParser[] supportedCommand = new CommandParser[]{
			new CreationCommandParser(),
			new QuitCommandParser(),
			new LineCommandParser(),
			new BucketFillCommandParser(),
			new RectangleCommandParser()
	};
	
	public static Command parse(String input) throws ParseException{
		for(CommandParser parser:supportedCommand){
			Command command = parser.parse(input);
			if(command!=null) return command;
		}
		throw new ParseException("unrecognised input:"+input);
	}
}
