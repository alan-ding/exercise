package org.jiang.exercise.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.jiang.exercise.command.BucketFillCommand;
import org.junit.Test;

public class BucketFillCommandParserTest {

	private CommandParser parser = new BucketFillCommandParser();

	@Test
	public void commandParseTestPositive() {
		BucketFillCommand expected = new BucketFillCommand(3,4,'r');
		assertEquals(expected,parser.parse("B 3 4 r"));
	}

	/**
	 * parse fail due to first letter wrong
	 */
	@Test
	public void commandParseTestNegative() {
		assertNull(parser.parse("A 3 4 r"));
	}

	/**
	 * parse fail due to wrong parameters following
	 */
	@Test
	public void commandParseTestNegative2() {
		assertNull(parser.parse("B 3 4 5s"));
	}

}
