package ui;

import java.util.Scanner;

import Threads.ProgressGadgetThread;
import javafx.scene.control.Label;
import model.ProgressGadget;
import model.SimpleProgressBar;


public class ProgressUI {
	private ProgressGadgetThread[] threads;
	private ProgressGadget[] progressG;
	public static final int NUM_THREADS = 1;
	private Label carga;
	
	public static final int MIN_SLEEP = 50;	
	public static final int MAX_SLEEP = 100;	

	public ProgressUI() {
	}
	
	private void createProgressGadgets(int[] maximums) {
		progressG = new ProgressGadget[NUM_THREADS];
		int i = 0;
		
		progressG[i] = new SimpleProgressBar(maximums[i],'#');
		i++;
		
		
		threads = new ProgressGadgetThread[NUM_THREADS];
		for(int k=0;k<NUM_THREADS;k++) {
			threads[k] = new ProgressGadgetThread(progressG[k],this,MIN_SLEEP+(int)(Math.random()*(MAX_SLEEP-MIN_SLEEP)),  carga);
		}		
	}
	
	private int[] readInputs() {
		System.out.print("Please, enter the maximum values for each progress gadget: ");
		Scanner sc = new Scanner(System.in);
		String[] parts = sc.nextLine().split(" ");
		sc.close();
		int[] maxs = new int[parts.length];
		for(int i=0;i<parts.length;i++) {
			maxs[i] = Integer.parseInt(parts[i]);
		}
		return maxs;
	}
	
	public void startProgress() {
		createProgressGadgets(readInputs());
		
		for(ProgressGadgetThread pgt: threads) {
			pgt.start();
		}
		System.out.println("[S]    [ SIMPLE PROG BAR ]    ");
	}

	public void refresh() {
		String progressState = "\r";
		for(ProgressGadget pg: progressG) {
			progressState += pg.getState();
		}
		System.out.print(progressState);
	}
}
