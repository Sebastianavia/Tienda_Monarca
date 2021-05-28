package Threads;

import model.ProgressGadget;
import ui.Main;
import ui.ProgressUI;

public class ProgressGadgetThread extends Thread{
	private ProgressGadget pg;
	private Main psui;
	private long sleepTime;
	
	
	
	public ProgressGadgetThread(ProgressGadget p, Main main, long st) {
		pg = p;
		psui = main;
		sleepTime = st;
		
	}
	
	public void run() {
		while(!pg.finished()) {
			pg.advance();
			//psui.refresh();
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
