package src;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.util.Duration; 
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;

public class rubikCube extends Application{
	
	protected static double Xm = 1200/2;
	protected static double Ym = 960/2 - 50;
	protected static double Zm = 2000/2;
	private double spinTime = 1;
	
	public void start(Stage stage) {

		//Creating the Rubik's Cube
		createBigCubes bCube = new createBigCubes();	
		createSmallCubes sCube = new createSmallCubes();
		
		//Control
		Button Lbutton = new Button("Left");
		Lbutton.setLayoutX(20);
		Lbutton.setLayoutY(200);
				
		Button Rbutton = new Button("Right");
		Rbutton.setLayoutX(100);
		Rbutton.setLayoutY(200);
				
		Button Ubutton = new Button("Up");
		Ubutton.setLayoutX(65);
		Ubutton.setLayoutY(160);
				
		Button Dbutton = new Button("Down");
		Dbutton.setLayoutX(60);
		Dbutton.setLayoutY(240);
		
		createBigCubes.createBClrt();
		createBigCubes.createBCurt();
		
		createSmallCubes.createSBlrt();
		createSmallCubes.createSBurt();
		
		Lbutton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	         public void handle(MouseEvent event) { 
	        	 Timeline timeline = new Timeline();
	        	 for(int i = 0; i<26; i++) {
	        		 if(i<12) {
	        			 timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(spinTime), new KeyValue(createBigCubes.BClrtRotate.get(i).angleProperty(),createBigCubes.BClrtRotate.get(i).getAngle()+90)));
	        		 }
	        		 for(int j = 0; j<26; j++) {
	        			 timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(spinTime), new KeyValue(createSmallCubes.SBlrtRotate.get(i).get(j).angleProperty(),createSmallCubes.SBlrtRotate.get(i).get(j).getAngle()+90)));
	        		 }
	        	 }	
	        	 timeline.play();
	         } 
		}));
		
		Rbutton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	         public void handle(MouseEvent event) { 
	        	 Timeline timeline = new Timeline();
	        	 for(int i = 0; i<26; i++) {
	        		 if(i<12) {
	        			 timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(spinTime), new KeyValue(createBigCubes.BClrtRotate.get(i).angleProperty(),createBigCubes.BClrtRotate.get(i).getAngle()-90)));
	        		 }
	        		 for(int j = 0; j<26; j++) {
	        			 timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(spinTime), new KeyValue(createSmallCubes.SBlrtRotate.get(i).get(j).angleProperty(),createSmallCubes.SBlrtRotate.get(i).get(j).getAngle()-90)));
	        		 }
	        	 }	
	        	 timeline.play();
	         } 
		}));
		
		Ubutton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	         public void handle(MouseEvent event) { 
	        	 Timeline timeline = new Timeline();
	        	 for(int i = 0; i<26; i++) {
	        		 if(i<12) {
	        			 timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(spinTime), new KeyValue(createBigCubes.BCurtRotate.get(i).angleProperty(),createBigCubes.BCurtRotate.get(i).getAngle()-90)));
	        		 }
	        		 for(int j = 0; j<26; j++) {
	        			 timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(spinTime), new KeyValue(createSmallCubes.SBurtRotate.get(i).get(j).angleProperty(),createSmallCubes.SBurtRotate.get(i).get(j).getAngle()-90)));
	        		 }
	        	 }	
	        	 timeline.play();
	         } 
		}));
		
		Dbutton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	         public void handle(MouseEvent event) { 
	        	 Timeline timeline = new Timeline();
	        	 for(int i = 0; i<26; i++) {
	        		 if(i<12) {
	        			 timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(spinTime), new KeyValue(createBigCubes.BCurtRotate.get(i).angleProperty(),createBigCubes.BCurtRotate.get(i).getAngle()+90)));
	        		 }
	        		 for(int j = 0; j<26; j++) {
	        			 timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(spinTime), new KeyValue(createSmallCubes.SBurtRotate.get(i).get(j).angleProperty(),createSmallCubes.SBurtRotate.get(i).get(j).getAngle()+90)));
	        		 }
	        	 }	
	        	 timeline.play();
	         } 
		}));
		
		//Camera
		PerspectiveCamera camera = new PerspectiveCamera(false);
		camera.setTranslateX(0);
		camera.setTranslateY(0);
		camera.setTranslateZ(0);
		
		//Group
		Group root = new Group(Lbutton, Rbutton, Ubutton, Dbutton);
		for(int i = 0; i<26; i++) {
			if(i<12) {
				root.getChildren().add(createBigCubes.BigCubes.get(i));
			}
			for(int j = 0; j<26; j++) {
				root.getChildren().add(createSmallCubes.SmallCubes.get(i).get(j));
			}
		}
		
		//Scene
		Scene scene = new Scene(root, Xm*2, Ym*2 + 100, true, SceneAntialiasing.BALANCED);
		scene.setCamera(camera);
		
		//Stage
		stage.setScene(scene);
		stage.show();	
	}
	
	public static void main(String args[]) {
		launch(args);
	}
}