package attendanceProgramUI;
import attendanceProgram.Dean;
import attendanceProgram.Teacher;
import attendanceProgram.Student;

import java.util.*;

import attendanceProgram.Dean;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;



@SuppressWarnings("unused")
public class tester extends Application{
   Teacher Chidi = new Teacher("Chidi Anagonye", 36, "Philosophy", 55035.34);
   Dean d1 = new Dean("Marie Eleo", 44, 90234.90);
   static Student Tahj = new Student("Tahj Dosso", 14, 34512);
   static Student Derrick = new Student("Derrick Ousley" , 14, 57238);
   static Student Nadia = new Student("Nadia Lino", 15, 26172);
   static Student Eleanor = new Student("Eleanor ShellStrop", 15, 34671);
   
   
   //okay
   //so what I'm trying to do here is create an array list of Students
   //so later on I can iterate through and retrieve the student object 
   //and then use the student object with the method
   
   
   public tester(){
   
   Chidi.addStudent(Tahj);
   Chidi.addStudent(Derrick);
   Chidi.addStudent(Nadia);
   Chidi.addStudent(Eleanor);
   Chidi.addAbsences(Tahj, 6);
   Chidi.addAbsences(Derrick, 9);
   Chidi.addAbsences(Nadia, 4);
   Chidi.addAbsences(Eleanor, 12);
   Chidi.addTardies(Tahj, 3);
   Chidi.addTardies(Derrick, 2);
   Chidi.addTardies(Nadia, 12);
   Chidi.addTardies(Eleanor, 23);
   
   
   
   }
   
   public static void main(String[] args) {

      launch(args);
      
      
   } 
     
   //declaring the scenes
   Scene scene, teacherScene, loginScene, deanScene, absenceScene, probationScene, deanStudent, deanTeacher;
   
   @Override
   public void start(Stage primaryStage) {
      
      Hashtable<String, Student> h = new Hashtable<String, Student>();
      h.put("Tahj", Tahj);
      h.put("Derrick", Derrick);
      h.put("Nadia", Nadia);
      h.put("Eleanor", Eleanor);
      
          
      primaryStage.setTitle("Tester App");
      GridPane grid = new GridPane();
      GridPane grid2 = new GridPane();
      GridPane grid3 = new GridPane();
      GridPane grid4 = new GridPane();
      
      //home page scene
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
               
        
      //reads the name and pin fields 
      //will match the name and pin to a teacher that is available 
        //^^not done yet
      //moves user to Teacher page 
      Button goButton = new Button("Go");
         logGrid.add(goButton, 8, 8);
         goButton.setOnAction((action) -> {
            String storedName = nameText.getText();
          
            //System.out.println(storedName);
            primaryStage.setScene(teacherScene);            
         });

            goButton.setDisable(true);
            nameText.textProperty().addListener(new ChangeListener<String>() {
            
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
               if(t1.equals(""))
                  goButton.setDisable(true);
               else
                  goButton.setDisable(false);
            }
            
            
         });
         
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
        printAttendance.setOnAction(e -> Chidi.printAttendance());
      
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
         //need to use a specific teacher 
         //subclass of scene that has a teacher field 
         teacherInfo.setOnAction(e -> Chidi.printTeacherInfo());
         
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
      Label studLabel = new Label("Enter the name of the student");
      TextField addStudentName = new TextField();
         grid4.add(addStudentName, 0, 3);
      Button addTardy = new Button("Add a Tardy");
         grid4.add(addTardy, 0, 2);
            addTardy.setOnAction((action) -> {
               String tardyStudent = addStudentName.getText();
               Student theStudent = h.get(tardyStudent);
               Chidi.addTardies(theStudent, 1); 
               System.out.println("Tardy added to " + tardyStudent);
            });
         

      Button subTardy = new Button("Remove a Tardy");
         grid4.add(subTardy, 2, 2);
         subTardy.setOnAction((action) -> {
               String notTardyStudent = addStudentName.getText();
               Student theStudent = h.get(notTardyStudent);
               Chidi.subtractTardies(theStudent, 1);
               System.out.println("Tardy subtracted from " + notTardyStudent);
         });         
         
      Button addAbsence = new Button("Add an Absence");
         grid4.add(addAbsence, 0, 4);
         addAbsence.setOnAction((action) -> {
            String absentStudent = addStudentName.getText();
            Student theStudent = h.get(absentStudent);
            Chidi.addAbsences(theStudent, 2); 
            System.out.println("Absence added to " + absentStudent);
         });
         
      Button subAbsence = new Button("Remove an Absence");
         grid4.add(subAbsence, 2, 4);
         subAbsence.setOnAction((action) -> {
            String notAbsentStudent = addStudentName.getText();
            Student theStudent = h.get(notAbsentStudent);
            Chidi.subtractAbsences(theStudent, 2); 
            System.out.println("Tardy removed from " + notAbsentStudent);
         });      
                  
//      Button compareToCap = new Button("Compare to Max");
//         grid4.add(compareToCap, 0, 6);
//         compareToCap.setOnAction((action) -> {
//            String comparedStudent = addStudentName.getText();
//            Student theStudent = h.get(comparedStudent);
//            
//            List<Student>
//            Chidi.compareToCap(Teacher.class.attendanceList, 6);
//         }); 
//         
         
      Button back = new Button("Back");
         grid4.add(back, 0, 8);
         back.setOnAction(e -> primaryStage.setScene(teacherScene));
         
/////////////////////////////////////////////////////////////////////////////////////////////
         
         //Student probation scene
         GridPane grid5 = new GridPane();
         probationScene = new Scene(grid5, 300, 200);
         Label label5 = new Label("Student Probation Page");
         Button printProbation = new Button("Print Probation");
            grid5.add(printProbation, 0, 4);
         Button resetProbation = new Button("Reset Probation List");
            grid5.add(resetProbation, 2, 4);
         Button backButton = new Button("Back");
            grid5.add(backButton, 0, 6);
            backButton.setOnAction(e -> primaryStage.setScene(teacherScene));
      
/////////////////////////////////////////////////////////////////////////////////////////////
      
      //dean scene 
      deanScene = new Scene(grid3, 300, 200);
      Label label4 = new Label("Dean Page");
         grid3.add(label4, 0, 0);
      Button studentButton = new Button("Students");
         grid3.add(studentButton, 0, 4);
         studentButton.setOnAction(e -> primaryStage.setScene(deanStudent));
      Button teacherButton = new Button("Teachers");
         grid3.add(teacherButton, 2, 4);
         teacherButton.setOnAction(e -> primaryStage.setScene(deanStudent));
         
      
         
//////////////////////////////////////////////////////////////////////////////////////////////         
         
      GridPane grid6 = new GridPane();   
      deanStudent = new Scene(grid6, 300, 200);
      Label studentLabel = new Label("This is where the Dean manipulates student info");
         grid6.add(studLabel, 0, 0);
      Button studentInfo = new Button("Student Info");
         grid6.add(studentInfo, 0, 4);
      Button moveStudent = new Button("Move Student");
         grid6.add(moveStudent, 2, 4);
      
     
      
      
///////////////////////////////////////////////////////////////////////////////////////////  
     
            
      //makes the window visible 
      //should be the last thing before you implement your code 
      primaryStage.setScene(scene);
      primaryStage.show();
        
      
      
   }
   

}
