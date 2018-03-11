package org.jiang.exercise.command.parser;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.jiang.exercise.command.QuitCommand;
import org.junit.Test;

public class QuitCommandParserTest {

	private CommandParser parser = new QuitCommandParser();

	@Test
	public void commandParseTestPositive() {
		assertTrue(parser.parse("Q") instanceof QuitCommand);
	}

	/**
	 * parse fail due to first letter wrong
	 */
	@Test
	public void commandParseTestNegative() {
		assertNull(parser.parse("A"));
	}

	/**
	 * parse fail due to wrong parameters following
	 */
	@Test
	public void commandParseTestNegative2() {
		assertNull(parser.parse("Q 1"));
	}

}
