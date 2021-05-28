package threads;

import javafx.application.Platform;
import javafx.scene.control.ProgressIndicator;

public class Percentage extends Thread{
	private ProgressIndicator prgres1;
	private double porcentaje;
	public Percentage(ProgressIndicator pg) {
		prgres1=pg;
		porcentaje = 0;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			porcentaje+=0.05;
			Platform.runLater(() -> { // Para cambiar algo grafico-- desde un hilo alternativo
				prgres1.setProgress(porcentaje);	//setprogre para el avance	
					
			});
			delay();
			//Platform.runLater(new Runnable() {			
				//@Override
				//public void run() {
					// TODO Auto-generated method stub					
				//}
			//});
		}
		
	}
	private void delay() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
