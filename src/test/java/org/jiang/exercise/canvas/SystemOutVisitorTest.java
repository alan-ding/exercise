package org.jiang.exercise.canvas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jiang.exercise.command.CreationCommand;
import org.junit.Before;
import org.junit.Test;

public class SystemOutVisitorTest {

	private AsciiCanvas canvas;
	private SystemOutVisitor visitor;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setup() {
		System.setOut(new PrintStream(outContent));
		canvas = new AsciiCanvas(2,2);
		visitor = new SystemOutVisitor();
		System.setErr(new PrintStream(errContent));
		CreationCommand initCommand = new CreationCommand(2,2);
		initCommand.visit(canvas);
	}
	
	@Test
	public void visitorTest() {
		visitor.visit(canvas);
		String expected = "----\n|  |\n|  |\n----\n";
		String output = outContent.toString();
		assertEquals(expected, output);
	}
}