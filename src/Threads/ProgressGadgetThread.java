package Threads;

import javafx.scene.control.Label;
import model.ProgressGadget;
import ui.ProgressUI;

public class ProgressGadgetThread extends Thread{
	private ProgressGadget pg;
	private ProgressUI psui;
	private long sleepTime;
	
	private Label carga;
	
	public ProgressGadgetThread(ProgressGadget p, ProgressUI ui, long st, Label carga) {
		pg = p;
		psui = ui;
		sleepTime = st;
		this.carga = carga;
	}
	
	public void run() {
		while(!pg.finished()) {
			pg.advance();
			psui.refresh();
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
