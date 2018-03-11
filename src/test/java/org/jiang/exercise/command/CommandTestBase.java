package org.jiang.exercise.command;

import static org.junit.Assert.assertEquals;

import org.jiang.exercise.ExerciseContext;
import org.jiang.exercise.canvas.AsciiCanvas;
import org.junit.Before;
import org.junit.Test;

public class CommandTestBase {

	protected ExerciseContext context;
	protected Command creationCommand;
	protected Command testCommand;
	int width = 8;
	int height = 9;
			
	@Before
	public void setup() throws Exception{
		context = new ExerciseContext();
		init();
	}
	
	public void init() throws Exception{
		creationCommand = new CreationCommand(width,height);
		creationCommand.execute(context);
	}

	@Test 
	public void testCreation() {
		valueTest(1,1,width,height,' ');
	}
	
	/**
	 * To test all the pixel in the range are filled with expected value. otherwise are filled with ' '
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 * @param expected
	 */
	void valueTest(int fromX,int fromY, int toX,int toY, char expected) {
		char[][] data = ((AsciiCanvas)context.getCanvas()).getPixels();
		for(int w = 1;w<=width;w++) {
			for(int h=1;h<=height;h++)
				if(w>=fromX && w<=toX && h>=fromY && h<=toY) {
					assertEquals(expected,data[w][h]);
				}else {
					assertEquals(' ',data[w][h]);
				}
		}	
	}
	
	boolean inRectEdge(int x, int y,int recX1,int recY1,int recX2,int recY2) {
		return ( (x==recX1||x==recX2) && y>=recY1 && y<=recY2 ) ||
			   ( (y==recY1 || y==recY2) && x>=recX1 && x<=recX2);
	}

	boolean outsideRect(int x, int y,int recX1,int recY1,int recX2,int recY2) {
		return x<recX1 || x > recX2 || y < recY1 || y > recY2;
	}
	boolean insideRect(int x, int y,int recX1,int recY1,int recX2,int recY2) {
		return x>recX1 && x< recX2 && y > recY1 && y < recY2;
	}
}
