package ui;


import java.awt.Label;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*; 



public class Main extends Application {
    
	
	private TiendaMonarcaGUI tiendaMonarcaGUI;

    @FXML
    private Label carga;

    public Main() throws ClassNotFoundException, IOException {
            
           tiendaMonarcaGUI = new TiendaMonarcaGUI();
        
    }

    public static void main(String [] args) {
        launch(args);
        
    		
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Welcome.fxml"));

		fxmlLoader.setController(tiendaMonarcaGUI);
		Parent root = fxmlLoader.load();
        Image icon= new Image("/img/circle-cropped.png");
        primaryStage.getIcons().add(icon);
		Scene scene = new Scene(root);

        scene.getStylesheets().add("/styles/styles.css");

		primaryStage.setScene(scene);
		primaryStage.setTitle("Tienda Monarca");
		primaryStage.show();
				
			
    	/*
    	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("White.fxml"));
		fxmlLoader1.setController(tiendaMonarcaGUI);
		Parent root2= fxmlLoader1.load();
		Scene scene=  new Scene (root2);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Restaurant");
		primaryStage.show();
		tiendaMonarcaGUI.inicializedMain();
		*/
		}
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*private ProgressGadgetThread[] threads;
	private ProgressGadget[] progressG;
	public static final int NUM_THREADS = 1;
	public static final int MIN_SLEEP = 50;	
	public static final int MAX_SLEEP = 100;	
	
	private void createProgressGadgets(int[] maximums) {
		progressG = new ProgressGadget[NUM_THREADS];
		int i = 0;
		
		progressG[i] = new SimpleProgressBar(maximums[i],'#');
		i++;
		
		
		threads = new ProgressGadgetThread[NUM_THREADS];
		for(int k=0;k<NUM_THREADS;k++) {
			threads[k] = new ProgressGadgetThread(progressG[k],this,MIN_SLEEP+(int)(Math.random()*(MAX_SLEEP-MIN_SLEEP)));
		}		
	}
	
	private int[] readInputs() {
		//System.out.print("Please, enter the maximum values for each progress gadget: ");
		//Scanner sc = new Scanner(System.in);
		//String[] parts = sc.nextLine().split(" ");
		//sc.close();
		int[] maxs = new int[1];
		//for(int i=0;i<parts.length;i++) {
			maxs[0] = 1000;
		//}
		return maxs;
	}
	
	public void startProgress() {
		createProgressGadgets(readInputs());
		System.out.println("entra");
		//for(ProgressGadgetThread pgt: threads) {
			ProgressGadgetThread pgt = threads[0];
			pgt.start();
		//}
		//	carga.setText("1");
			carga.setText("[S]    [ SIMPLE PROG BAR ]    [ LINES PROGR BAR ]    [ ROTATE PROG BAR ]    [  SPACESHIP BAR  ]    [    ARROW BAR    ]");
	}

	public void refresh() {
		String progressState = "\r";
		for(ProgressGadget pg: progressG) {
			progressState += pg.getState();
		}
		System.out.print(progressState);
	}*/
	



}
