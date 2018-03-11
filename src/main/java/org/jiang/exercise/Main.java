package org.jiang.exercise;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jiang.exercise.canvas.Canvas;
import org.jiang.exercise.canvas.AsciiCanvas;
import org.jiang.exercise.command.Command;
import org.jiang.exercise.command.CommandFactory;
import org.jiang.exercise.command.ExecutionException;
import org.jiang.exercise.command.parser.ParseException;


public class Main {
	private ExerciseContext context = new ExerciseContext();
	private BufferedReader input;
	
	public Main() {
		input = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] arg) throws IOException {
		Main app = new Main();
		ExerciseContext context = app.context;
		printUsage();
		while(true) {
			String strCommand = app.readCommand();
			try {
				Command command = CommandFactory.parse(strCommand);
				command.execute(app.context);
				Canvas canvas = context.getCanvas();
				if(canvas!=null) {
					context.getPrintVisitor().visit((AsciiCanvas)canvas);					
				}
			} catch (ParseException e) {
				System.out.println("please enter a valid command. Refer to command/format supported");
				e.printStackTrace();
			} catch (ExecutionException e) {
				System.out.println("please enter a valid command. Refer to command/format supported");
				e.printStackTrace();
			}
		}
	}

	private String readCommand() throws IOException {
		return input.readLine().trim();
	}
	
	
	private static void printUsage() {
		System.out.println(
		"|Command 		|Description|\r\n" + 
		"|----   |----   |\r\n" + 
		"|C w h          | Create a new canvas of width w and height h.|\r\n" + 
		"|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|\r\n" + 
		"|               | horizontal or vertical lines are supported. Horizontal and vertical lines|\r\n" + 
		"|               | will be drawn using the 'x' character.|\r\n" + 
		"|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|\r\n" + 
		"|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|\r\n" + 
		"|               | using the 'x' character.|\r\n" + 
		"|B x y c        | Fill the entire area connected to (x,y) with \"colour\" c. The|\r\n" + 
		"|               | behaviour of this is the same as that of the \"bucket fill\" tool in paint|\r\n" + 
		"|               | programs.|\r\n" + 
		"|Q              | Quit|\r\n");
	}
}