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
		valueTest(0,0,width-1,height-1,' ');
	}
	
	void valueTest(int fromX,int fromY, int toX,int toY, char expected) {
		char[][] data = ((AsciiCanvas)context.getCanvas()).getPixels();
		for(int w = 0;w<width;w++) {
			for(int h=0;h<height;h++)
				if(w>=fromX && w<=toX && h>=fromY && h<=toY) {
					assertEquals(expected,data[w][h]);
				}else {
					assertEquals(' ',data[w][h]);
				}
		}	
	}
	
	boolean inRectEdge(int w, int h,int recX1,int recY1,int recX2,int recY2) {
		return ( (w==recX1||w==recX2) && h>=recY1 && h<=recY2 ) ||
			   ( (h==recY1 || h==recY2) && w>=recX1 && w<=recX2);
	}

	boolean outsideRect(int w, int h,int recX1,int recY1,int recX2,int recY2) {
		return w<recX1 || w > recX2 || h < recY1 || h > recY2;
	}
	boolean insideRect(int w, int h,int recX1,int recY1,int recX2,int recY2) {
		return w>recX1 && w< recX2 && h > recY1 && h < recY2;
	}
}
