import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

////////////////////////////////////////////////////////////////////////////////
// File:             AttendanceGUI.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

/**
 * 
 */
public class AttendanceGUI extends Application {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      launch(args);

   }

   /* (non-Javadoc)
    * @see javafx.application.Application#start(javafx.stage.Stage)
    */
   @Override
   public void start(Stage stage) throws Exception {
      // TODO Auto-generated method stub
      
      
      
      Button teacher = new Button("For Teachers");
     teacher.setOnAction(e -> {
           System.out.println("This is for Teachers");    
     });
      
      Button dean = new Button("For Deans");
      dean.setOnAction(e -> {
         System.out.println("This is for Deans");
      });
      HBox Buttons = new HBox(teacher, dean);
      Buttons.setSpacing(15);
      
      
     
      BorderPane root = new BorderPane();
      
      root.setCenter(Buttons);
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Attendance Program");
      stage.show();
   }

}
