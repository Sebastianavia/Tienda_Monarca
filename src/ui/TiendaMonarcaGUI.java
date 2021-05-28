package ui;


import java.io.IOException;
import java.sql.Time;
import java.util.Timer;

import javax.swing.JProgressBar;
import javax.xml.stream.events.StartDocument;

import org.omg.CORBA.ServiceInformation;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.TiendaMonarca;

public class TiendaMonarcaGUI {
	
	@FXML
    private BorderPane pane;
	@FXML
	private Text labelUser;
	@FXML
    private MenuItem labelLoginOrLogOut;
	@FXML
    private ProgressBar jProgressbar1;
	
    @FXML
	private ProgressIndicator prgres1;


	
	//---------------------------------------
	@FXML
    private Label carga;
	
	private Timer timer;
	int centesimas = 0;
	int seconds = 0;

	 private TiendaMonarca TiendaMonarca;

	    public TiendaMonarcaGUI(TiendaMonarca controller) {
	        TiendaMonarca = controller;
	    }
	    
	    
	    
	    //________________________________________________________
	    
	   
	    
	  public int Timer() {
		  centesimas++;
		  if(centesimas == 100)
			  seconds++;
		  
		  return Timer();
	  }
	    
	    
	    	 @FXML
	 	    public void InitProgram(ActionEvent event) throws IOException {
	    		 
	 	        
	 	        do {
	 	        final Service thread = new Service<Integer>() {

					@Override
					public Task createTask() {
						
						return new Task<Integer>() {

							@Override
							public Integer call() throws InterruptedException {
								int i;
								for (i= 0; i< 100; i++) {
									updateProgress(i, 100);
									Thread.sleep(10);
								}
								return i;
							}
							
						};
					}
	 	        	
	 	        };
	 	        
	 	        String s  = "4";
				Task task = taskCreator(Integer.parseInt(s));
	 	       jProgressbar1.progressProperty().bind(thread.progressProperty());
	 	      prgres1.progressProperty().unbind();
	 	       
			prgres1.progressProperty().bind(task.progressProperty());
	 	       new Thread(task).start();
	 	       
	 	       
	 	       
	 	       

	 	        }while(Timer()<5);
	 	        
	 	       /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
	 	        fxmlLoader.setController(this);
	 	        Parent login = fxmlLoader.load();
	 	        pane.getChildren().clear();
	 	        pane.setCenter(login);

	 	        labelUser.setText("Usuario");
	 	        labelLoginOrLogOut.setText("Login");*/
	 	   
	    	 }
	    	 
	    	 private Task taskCreator(int secondss) {
	    		 return new Task() {

					@Override
					protected Object call() throws Exception {
						for (int i = 0; i < secondss; i++) {
							Thread.sleep(1000);
							updateProgress(i+1, secondss);
						}
						return true;
					}
	    			 
	    		 };
	    		 
	    	 }
	 	    	
	 	    	


			
		
	     
	    
	   
	    
	    
	    


}
