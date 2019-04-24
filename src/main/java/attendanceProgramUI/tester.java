package attendanceProgramUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class tester extends Application{
   public static void main(String[] args) {
      launch(args);
   } 
     
   //declaring the scenes
   Scene scene, teacherScene, deanScene;
   
   @Override
   public void start(Stage primaryStage) {
          
      primaryStage.setTitle("Tester App");
      GridPane grid = new GridPane();
      GridPane grid2 = new GridPane();
      GridPane grid3 = new GridPane();
      
      //homepage scene
      Label label = new Label("Homepage");
      grid.add(label, 0, 0);
      Button btn1 = new Button("Teacher");
      grid.add(btn1, 0, 2);
      Button btn2 = new Button("Dean");
      grid.add(btn2, 6, 2);
      btn1.setOnAction(e -> primaryStage.setScene(teacherScene));
      btn2.setOnAction(e -> primaryStage.setScene(deanScene));
      scene = new Scene(grid, 300, 200);
            
      //teacher scene
      teacherScene = new Scene(grid2, 300, 200);
      Label label2 = new Label("Teacher Page");
         grid2.add(label2, 3, 0);
      Button homeButton = new Button("Home");
         grid2.add(homeButton, 2, 2);
      
      homeButton.setOnAction(e -> primaryStage.setScene(scene));
            
      //dean scene 
      deanScene = new Scene(grid3, 300, 200);
      Label label3 = new Label("Dean Page");
      grid3.add(label3, 0, 0);
      Label aLabel = new Label("This page doesnt do anything yet");
         grid3.add(aLabel, 3, 3);
      
      //makes the window visible 
      primaryStage.setScene(scene);
      primaryStage.show();
            
   }

}
