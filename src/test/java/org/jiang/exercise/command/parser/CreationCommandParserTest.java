package org.jiang.exercise.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.jiang.exercise.command.CreationCommand;
import org.jiang.exercise.command.LineCommand;
import org.jiang.exercise.command.RectangleCommand;
import org.junit.Test;

public class CreationCommandParserTest {

	private CommandParser parser = new CreationCommandParser();

	@Test
	public void commandParseTestPositive() {
		CreationCommand expected = new CreationCommand(7,8);
		assertEquals(expected,parser.parse("C 7 8"));
	}

	/**
	 * parse fail due to first letter wrong
	 */
	@Test
	public void commandParseTestNegative() {
		assertNull(parser.parse("B 7 8"));
	}

	/**
	 * parse fail due to wrong parameters following
	 */
	@Test
	public void commandParseTestNegative2() {
		assertNull(parser.parse("C 7 8 7"));
	}

}
