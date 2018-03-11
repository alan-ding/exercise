package org.jiang.exercise.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.jiang.exercise.command.RectangleCommand;
import org.junit.Test;

public class RectangleCommandParserTest {

	private CommandParser parser = new RectangleCommandParser();

	@Test
	public void commandParseTestPositive() {
		RectangleCommand expected = new RectangleCommand(1,2,3,4);
		assertEquals(expected,parser.parse("R 1 2 3 4"));
	}

	/**
	 * parse fail due to first letter wrong
	 */
	@Test
	public void commandParseTestNegative() {
		assertNull(parser.parse("A 1 2 3 4"));
	}

	/**
	 * parse fail due to wrong parameters following
	 */
	@Test
	public void commandParseTestNegative2() {
		assertNull(parser.parse("R 2 3 4 4 5"));
	}

}
