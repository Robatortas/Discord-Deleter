package robatortas.code.files;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/*
 * This script's purpose is for the bulk deletion of discord messages.
 * It's a small but potent script!
 * 
 * To delete the messages we will need to hotkey stuff.
 * 
 * To delete a single discord message we need to:
 * 		-up key
 * 		-ctrl+a
 * 		-backspace
 * 		-enter
 * 		-enter again to confirm
 * 
 * So we just repeat that process while the thread is alive!
 * 
 * Made by Robatortas.
 */
public class Deleter {
	
	private Scanner readInput = new Scanner(System.in);
	private String input;
	
	private Robot robot;
	
	public Deleter() {
		try {
			console();
		} catch (AWTException e) {
			writeErr("Exception with Robot variable. JVM Exception: " + e.getMessage());
		}
	}
	
	public void console() throws AWTException {
		writeMsg("Starting Discord Deleter\n\n"
				+ "Welcome to Discord Deleter made by Robatortas.\n\n"
				+ "Leave your discord chat open while having this application running\n"
				+ "If you would like to exit the application, simply exit the command line.\n\n"
				+ "Press enter to start process.\n\n"
				+ "Waiting for input...");
		
		this.input = readInput.nextLine().toLowerCase();
		
		for(int i = 5; i > 0;) {
			try {
				Thread.sleep(1000);
				i--;
				writeMsg("Starting process in " + i);
			} catch (InterruptedException e) {
				writeErr("Thread unable to sleep. JVM Exception" + e.getMessage());
			}
		}
		
		while(Thread.currentThread().isAlive()) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			process();
		}
	}
	
	public void process() throws AWTException {
		robot = new Robot();
		
		int up = KeyEvent.VK_UP;
		int ctrl = KeyEvent.VK_CONTROL;
		int back = KeyEvent.VK_BACK_SPACE;
		int enter = KeyEvent.VK_ENTER;
		
		robot.keyPress(up);
		robot.keyRelease(up);
		robot.keyPress(ctrl);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(ctrl);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(back);
		robot.keyRelease(back);
		robot.keyPress(enter);
		robot.keyRelease(enter);
		robot.keyPress(enter);
		robot.keyRelease(enter);
		robot.keyPress(enter);
		robot.keyRelease(enter);
	}
	
	
	// Log methods
	public void writeMsg(String msg) {
		System.out.println(msg);
	}
	
	public void writeErr(String err) {
		System.err.println(err);
	}
}