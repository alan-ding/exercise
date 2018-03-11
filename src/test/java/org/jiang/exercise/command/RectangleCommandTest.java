package org.jiang.exercise.command;

import static org.junit.Assert.assertEquals;

import org.jiang.exercise.canvas.AsciiCanvas;
import org.junit.Before;
import org.junit.Test;

public class RectangleCommandTest extends CommandTestBase{
	
	int x1 = 2;
	int x2 = 5;
	int y1 = 4;
	int y2 = 8;
	@Before
	public void setup() throws Exception {
		super.setup();
		testCommand = new RectangleCommand(x1,y1,x2,y2);
		
	}
	@Test
	public void visitorTest() throws Exception{
		testCommand.execute(context);
		AsciiCanvas canvas = ((AsciiCanvas)context.getCanvas());
		char[][] data = canvas.getPixels();
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		for(int w = 0;w<width;w++) {
			for(int h = 0;h<height;h++) {
				if(inRectEdge(w,h,x1,y1,x2,y2)) {
					assertEquals('x',data[w][h]);
				}else {
					assertEquals(' ',data[w][h]);
				}
			}
		}
	}

}
