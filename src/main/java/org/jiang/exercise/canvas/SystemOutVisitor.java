package org.jiang.exercise.canvas;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class SystemOutVisitor implements CanvasVisitor{
	
	BufferedOutputStream out;
	
	public SystemOutVisitor() {
		out = new BufferedOutputStream(System.out);
	}
	
	@Override
	public void visit(AsciiCanvas canvas) {
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		try {
			printHorizentalBorder(width);
			newLine();
			char[][] pixels = canvas.getPixels();
			for(int h=0;h<height;h++){
				printVerticalBorder();
				for(int w=0;w<width;w++){
					printChar(pixels[w][h]);
				}
				printVerticalBorder();
				newLine();
			}
			printHorizentalBorder(width);
			newLine();
			out.flush();
		} catch (Exception e) {
			System.err.println("output canvas to console error:");
			e.printStackTrace();
		}
	}

	private void printHorizentalBorder(int width) throws Exception{
		for(int i = -1;i<=width;i++)
			out.write('-');
	}
	
	private void printVerticalBorder() throws Exception{
		out.write('|');
	}
	
	private void newLine() throws Exception{
//		out.write('\r'); //TBD deal with different OS
		out.write('\n');
	}
	
	private void printChar(char c) throws Exception{
		out.write(c);
	}

	public void dispose() throws IOException {
		out.close();
	}
}
