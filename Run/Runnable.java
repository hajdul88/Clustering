package Run;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import Clustering.Coloring;
import Graph.Network;
import Reader.Read;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


//public class Runnable extends Application {
public class Runnable {
	//ProgressIndicator pb = new ProgressIndicator();
	//Network net;
	//Button btn1 = new Button();
	//Button btn2 = new Button();
	//Thread thread = new Thread();
	public static void main(String[] args) throws IOException{
		//launch(args);
		Network net1=Read.ReadCsv("C:\\Users\\hajdul\\Desktop\\infectionNetwork\\real\\elso.csv");
		Coloring.RunSyncColoring(net1);
	}
	/*
	@Override
	public void start(Stage primaryStage) throws Exception{
		Button btn1 = new Button();
		Button btn2 = new Button();
		Text t= new Text("  Graph ready");
        btn1.setText("Read Network");
        btn2.setText("Run");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	if(!thread.isAlive()) {
            	FileChooser fileChooser = new FileChooser();
            	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Semicolon Delimited (*.csv)", "*.csv");
            	fileChooser.getExtensionFilters().add(extFilter);
            	fileChooser.setTitle("Gráf beolvasása");
            	File file=fileChooser.showOpenDialog(null);
            	if(file != null){
            		System.out.println(file.getAbsolutePath());
            			pb.setVisible(true);
            			btn1.setVisible(false);
            			btn2.setVisible(false);
            			System.gc();
            			net=new Network();
						thread = new Thread() {
					        public void run() {
					        	try {
									net=Read.ReadCsv(file.getAbsolutePath());
									System.out.println(net.getEdges().size());
									System.gc();
									btn2.setVisible(true);
									t.setVisible(true);
			            			pb.setVisible(false);
			            			
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					        };
					    };
						thread.start();
					
            		
            	}
            }
            }
        });
        t.setStyle("-fx-font-weight: bold");
        t.setStyle("-fx-font-size: 14px");
        StackPane root = new StackPane();
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(pb);
        root.getChildren().add(t);
        StackPane.setAlignment(btn1, Pos.CENTER_LEFT);
        StackPane.setAlignment(btn2, Pos.CENTER_RIGHT);
        StackPane.setAlignment(pb, Pos.CENTER);
        StackPane.setAlignment(t, Pos.CENTER_LEFT);
        t.setVisible(false);
        pb.setVisible(false);
        Scene scene = new Scene(root, 200, 50);

        primaryStage.setTitle("Markov");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	*/
}
