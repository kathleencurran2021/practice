package attendanceProgramUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class tester extends Application{
   public static void main(String[] args) {
      launch(args);
   }   
   
   @Override
   public void start(Stage primaryStage) throws Exception {
      primaryStage.setTitle("Tester App");
      
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));
      
      Scene scene = new Scene(grid, 300, 275);
      primaryStage.setScene(scene);
      
      primaryStage.show();
      
      Text scenetitle = new Text("welcome");
      grid.add(scenetitle, 0, 0, 2, 1);
      
      Button btn1 = new Button("Teacher");
      grid.add(btn1, 0, 2);
      
      Button btn2 = new Button("Dean");
      grid.add(btn2, 6, 2);
      
      
   }
   




}



