package attendanceProgramUI;
import attendanceProgram.Teacher;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
   Scene scene, teacherScene, loginScene, deanScene, absenceScene, probationScene;
   
   @Override
   public void start(Stage primaryStage) {
          
      primaryStage.setTitle("Tester App");
      GridPane grid = new GridPane();
      GridPane grid2 = new GridPane();
      GridPane grid3 = new GridPane();
      GridPane grid4 = new GridPane();

      
      //homepage scene
      Label label = new Label("Homepage");
         grid.add(label, 0, 0);
      Button btn1 = new Button("Teacher");
         grid.add(btn1, 0, 2);
      Button btn2 = new Button("Dean");
         grid.add(btn2, 6, 2);
      btn1.setOnAction(e -> primaryStage.setScene(loginScene));
      btn2.setOnAction(e -> primaryStage.setScene(deanScene));
      scene = new Scene(grid, 300, 200);
            
///////////////////////////////////////////////////////////////////////
      
      //login scene
      GridPane logGrid = new GridPane(); 
      loginScene = new Scene(logGrid, 250, 150);
      Label nameLabel = new Label("What is your name?");
         logGrid.add(nameLabel, 0, 0);
      TextField nameText = new TextField();
         logGrid.add(nameText, 0, 2);
         
     Label pinLabel = new Label("What is your pin?");
        logGrid.add(pinLabel, 0, 6);
     TextField pinText = new TextField();
        logGrid.add(pinText, 0, 8);
         
      Button goButton = new Button("Go");
         logGrid.add(goButton, 8, 8);
         goButton.setOnAction(e -> primaryStage.setScene(teacherScene));
      
////////////////////////////////////////////////////////////////////////////
      
      //teacher scene
      teacherScene = new Scene(grid2, 300, 200);
      Label label2 = new Label("Teacher Page");
         grid2.add(label2, 3, 0);
       
      //takes the user back to the home page
      Button homeButton = new Button("Home");
         grid2.add(homeButton, 2, 2);
         homeButton.setOnAction(e -> primaryStage.setScene(scene));
         
      //prints the attendance of the teacher's class
      Button printAttendance = new Button("Print Attendance");
         grid2.add(printAttendance, 2, 8);
         //printAttendance.setOnAction(e -> Teacher.class.printAttendance());
      
      //takes user to the probation page
      Button studentProbation = new Button("Student Probation");
         grid2.add(studentProbation, 8, 8);
         studentProbation.setOnAction(e -> primaryStage.setScene(probationScene));
         
      //switches to the Absence Scene   
      Button absences = new Button("Absences");
         grid2.add(absences, 8, 2);
         absences.setOnAction(e -> primaryStage.setScene(absenceScene));
         
      //Prints the teacher's information 
      Button teacherInfo = new Button("Show Teacher Info");
         grid2.add(teacherInfo, 2, 14);
         //teacherInfo.setOnAction(e -> Teacher.class.printTeacherInfo());
         
      //exits the GUI
      Button logOff = new Button("Log Off");
         grid2.add(logOff, 8, 14);
         logOff.setOnAction(e -> System.exit(0));

//////////////////////////////////////////////////////////////////////////////////////////////
            
      //Absence Page 
      //Where the teacher can manipulate the absences of their students 
      absenceScene = new Scene(grid4, 300, 200);
      Label label3 = new Label("Absence Page");
         grid4.add(label3, 0, 0);
      Button addTardy = new Button("Add a Tardy");
         grid4.add(addTardy, 0, 2);
      Button subTardy = new Button("Remove a Tardy");
         grid4.add(subTardy, 2, 2);
      Button addAbscence = new Button("Add an Absence");
         grid4.add(addAbscence, 0, 4);
      Button subAbsence = new Button("Remove an Absence");
         grid4.add(subAbsence, 2, 4);
      Button compareToCap = new Button("Compare to Max");
         grid4.add(compareToCap, 0, 6);
      Button back = new Button("Back");
         grid4.add(back, 0, 8);
         back.setOnAction(e -> primaryStage.setScene(teacherScene));
         
/////////////////////////////////////////////////////////////////////////////////////////////
         
         
         
      
/////////////////////////////////////////////////////////////////////////////////////////////
      
      //dean scene 
      deanScene = new Scene(grid3, 300, 200);
      Label label4 = new Label("Dean Page");
         grid3.add(label4, 0, 0);
      Label aLabel = new Label("This page doesnt do anything yet");
         grid3.add(aLabel, 3, 3);
      
///////////////////////////////////////////////////////////////////////////////////////////  
     
      GridPane grid5 = new GridPane();
      probationScene = new Scene(grid5, 300, 200);
      Label label5 = new Label("Student Probation Page");
      Button printProbation = new Button("Print Probation");
         grid5.add(printProbation, 0, 4);
      Button resetProbation = new Button("Reset Probation List");
         grid5.add(resetProbation, 2, 4);
         
      
         
         
      //makes the window visible 
      //should be the last thing before you implement your code 
      primaryStage.setScene(scene);
      primaryStage.show();
            
   }

}
