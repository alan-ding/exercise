package org.jiang.exercise.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.jiang.exercise.command.LineCommand;
import org.junit.Test;

public class LineCommandParserTest {

	private CommandParser parser = new LineCommandParser();

	@Test
	public void commandParseTestPositive() {
		LineCommand expected = new LineCommand(1,2,3,4);
		assertEquals(expected,parser.parse("L 1 2 3 4"));
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
	public void ommandParseTestNegative2() {
		assertNull(parser.parse("L 2 3 4"));
	}

}
