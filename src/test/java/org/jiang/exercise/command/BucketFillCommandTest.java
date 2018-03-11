package org.jiang.exercise.command;

import static org.junit.Assert.assertEquals;

import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.AsciiCanvas;
import org.junit.Before;
import org.junit.Test;

public class BucketFillCommandTest extends CommandTestBase{
	
	int x1 = 2,y1=2,x2=6,y2=6;
	/**
	 * draw a rectangle
	 */
	@Before
	public void setup() throws Exception {
		super.setup();		
	}
	
	@Test
	public void visitor_replaceAll_Test() throws Exception{
		testCommand = new BucketFillCommand(3,3,'0');
		testCommand.execute(context);
		Canvas canvas = context.getCanvas();
		valueTest(0,0,canvas.getWidth()-1,canvas.getHeight()-1, '0');
	}

	//flood inside
	@Test
	public void visitor_insideRectangle_Test() throws Exception{
		RectangleCommand rectCommand = new RectangleCommand(x1,y1,x2,y2);
		rectCommand.execute(context);
		testCommand = new BucketFillCommand(3,3,'0');
		testCommand.execute(context);
		Canvas canvas = context.getCanvas();
		char[][] pixels = ((AsciiCanvas)canvas).getPixels();
		int width  = canvas.getWidth();
		int height = canvas.getHeight();
		for(int w = 0;w<width;w++) {
			for(int h=0;h<height;h++) {
				if(inRectEdge(w,h,x1,y1,x2,y2)) {
					assertEquals('x',pixels[w][h]);
				}else if(insideRect(w,h,x1,y1,x2,y2)) {
					assertEquals('0',pixels[w][h]);
				}else if(outsideRect(w,h,x1,y1,x2,y2)) {
					assertEquals(' ',pixels[w][h]);
				}
			}
		}
	}

	//flood outside
	@Test
	public void visitor_outsideRectangle_Test() throws Exception{
		RectangleCommand rectCommand = new RectangleCommand(x1,y1,x2,y2);
		rectCommand.execute(context);
		testCommand = new BucketFillCommand(1,1,'0');
		testCommand.execute(context);
		Canvas canvas = context.getCanvas();
		char[][] pixels = ((AsciiCanvas)canvas).getPixels();
		int width  = canvas.getWidth();
		int height = canvas.getHeight();
		for(int w = 0;w<width;w++) {
			for(int h=0;h<height;h++) {
				if(inRectEdge(w,h,x1,y1,x2,y2)) {
					assertEquals('x',pixels[w][h]);
				}else if(insideRect(w,h,x1,y1,x2,y2)) {
					assertEquals(' ',pixels[w][h]);
				}else if(outsideRect(w,h,x1,y1,x2,y2)) {
					assertEquals('0',pixels[w][h]);
				}
			}
		}
	}

	//flood along the edge of rectangle
	@Test
	public void visitor_edgeRectangle_Test() throws Exception{
		RectangleCommand rectCommand = new RectangleCommand(x1,y1,x2,y2);
		rectCommand.execute(context);
		testCommand = new BucketFillCommand(x1,y1,'0');
		testCommand.execute(context);
		Canvas canvas = context.getCanvas();
		char[][] pixels = ((AsciiCanvas)canvas).getPixels();
		int width  = canvas.getWidth();
		int height = canvas.getHeight();
		for(int w = 0;w<width;w++) {
			for(int h=0;h<height;h++) {
				if(inRectEdge(w,h,x1,y1,x2,y2)) {
					assertEquals('0',pixels[w][h]);
				}else if(insideRect(w,h,x1,y1,x2,y2)) {
					assertEquals(' ',pixels[w][h]);
				}else if(outsideRect(w,h,x1,y1,x2,y2)) {
					assertEquals(' ',pixels[w][h]);
				}
			}
		}
	}
}