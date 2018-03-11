package org.jiang.exercise.command;

import org.junit.Before;
import org.junit.Test;

public class LineCommandTest extends CommandTestBase{
	
	@Before
	public void setup() throws Exception {
		super.setup();
		testCommand = new LineCommand(2,4,2,8);
	}
	
	@Test
	public void visitorTest() throws Exception{
		testCommand.execute(context);
		valueTest(2,4,2,8,'x');
	}
	
	/**
	 * draw a line out of canvas
	 * @throws ExecutionException
	 */
	@Test(expected=ExecutionException.class)
	public void visitorExceptionDuetoOutofbounds() throws ExecutionException {
		testCommand = new LineCommand(8,4,2,8);
		testCommand.execute(context);
	}

	/**
	 * draw a non horizontal/vertical line
	 * @throws ExecutionException
	 */
	@Test(expected=ExecutionException.class)
	public void visitorExceptionDuetoNotSupported() throws ExecutionException {
		testCommand = new LineCommand(1,2,3,4);
		testCommand.execute(context);
	}

}
