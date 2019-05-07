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
   Student Tahj = new Student("Tahj Dosso", 14, 34512);
   Student Derrick = new Student("Derrick Ousley" , 14, 57238);
   Student Nadia = new Student("Nadia Lino", 15, 26172);
   Student Eleanor = new Student("Eleanor ShellStrop", 15, 34671);
   
   Teacher Seuss = new Teacher("Seuss Rol", 54, "Reading", 43692.73);
   Student Shaq = new Student("Shaq Lee", 13, 34212);
   Student Ryan = new Student("Ryan Benlow", 14, 93213);
   Student Marrissa = new Student("Marissa Hig", 17, 89132);
   Student Long = new Student("Long Kei", 16, 34211);
   Student Claire = new Student("Claire Lemon", 14 , 76459);
   
   Teacher theTeacher = Chidi;
  
 
   public tester(){
      Chidi.addStudent(Tahj);
      Chidi.addStudent(Derrick);
      Chidi.addStudent(Nadia);
      Chidi.addStudent(Eleanor);

      Seuss.addStudent(Claire);
      Seuss.addStudent(Shaq);
      Seuss.addStudent(Marrissa);
      Seuss.addStudent(Long);
      Seuss.addStudent(Ryan);
   }
   
   public static void main(String[] args) {
      launch(args);
   } 
     
   //declaring the scenes
   Scene scene, teacherScene, loginScene, deanScene, absenceScene, probationScene, deanStudent, deanTeacher;
   
   @Override
   public void start(Stage primaryStage) {
      
      //puts all the student objects into a hashtable 'h'
      //all students begin with 0 tardies and 0 absences 
      Hashtable<String, Student> h = new Hashtable<String, Student>();
      h.put("Tahj", Tahj);
      h.put("Derrick", Derrick);
      h.put("Nadia", Nadia);
      h.put("Eleanor", Eleanor);
      h.put("Claire", Claire);
      h.put("Shaq", Shaq);
      h.put("Marrissa", Marrissa);
      h.put("Long", Long);
      h.put("Ryan", Ryan);
      
      //puts all the teacher objects into a hashtable 'hashteacher' 
      Hashtable<String, Teacher> hashTeacher = new Hashtable<String, Teacher>();
      hashTeacher.put("Chidi", Chidi);
      hashTeacher.put("Seuss", Seuss);
      
      d1.tList.add(Chidi);
      d1.tList.add(Seuss);
      
      primaryStage.setTitle("Tester App");
      
      //home page scene
      GridPane grid = new GridPane();
      scene = new Scene(grid, 300, 200);
      Label label = new Label("Homepage");
         grid.add(label, 0, 0);
      Button btn1 = new Button("Teacher");
         grid.add(btn1, 0, 2);
      Button btn2 = new Button("Dean");
         grid.add(btn2, 6, 2);
      //changes scene to the log in scene
      btn1.setOnAction(e -> primaryStage.setScene(loginScene));
      //changes scene to the dean scene 
      btn2.setOnAction(e -> primaryStage.setScene(deanScene));
      
            
///////////////////////////////////////////////////////////////////////
      
      //login scene
      GridPane logGrid = new GridPane(); 
      loginScene = new Scene(logGrid, 250, 150);
      Label nameLabel = new Label("What is your name?");
         logGrid.add(nameLabel, 0, 0);
      TextField nameText = new TextField();
         logGrid.add(nameText, 0, 2);
         
      //retrieves the name entered in the text field and stores it in a string variable
      //retrieves the teacher object with the string as a keyword
      //moves to the teacher scene
      Button goButton = new Button("Go");
         logGrid.add(goButton, 8, 8);
         goButton.setOnAction((action) -> {
            String storedName = nameText.getText();
            theTeacher = hashTeacher.get(storedName);
            primaryStage.setScene(teacherScene);            
         });
            //disables the button until there is some input 
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
      GridPane grid2 = new GridPane();
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
         printAttendance.setOnAction((action) -> {
            theTeacher.printAttendance();
         });
         
         
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
         teacherInfo.setOnAction((action) -> {
            theTeacher.printTeacherInfo();
         });
         
      //exits the GUI
      Button logOff = new Button("Log Off");
         grid2.add(logOff, 8, 14);
         logOff.setOnAction(e -> System.exit(0));

//////////////////////////////////////////////////////////////////////////////////////////////
            
      //Absence Page 
      //Where the teacher can manipulate the absences of their students
      GridPane grid4 = new GridPane();
      absenceScene = new Scene(grid4, 300, 200);
      Label studLabel = new Label("Enter the name of the student");
         grid4.add(studLabel, 0, 0);
      TextField addStudentName = new TextField();
         grid4.add(addStudentName, 0, 2);
      
         //adds a tardy to the student record
         //if successful, prints out a message saying a tardy was added
      Button addTardy = new Button("Add a Tardy");
         grid4.add(addTardy, 0, 4);
            addTardy.setOnAction((action) -> {
               String tardyStudent = addStudentName.getText();
               Student theStudent = h.get(tardyStudent);
               theTeacher.addTardies(theStudent, 2); 
               System.out.println("Tardy added to " + tardyStudent);
            });
         
            //removes a tardy from the student record
            //if successful, prints a message saying tardy was removed 
      Button subTardy = new Button("Remove a Tardy");
         grid4.add(subTardy, 2, 4);
         subTardy.setOnAction((action) -> {
               String notTardyStudent = addStudentName.getText();
               Student theStudent = h.get(notTardyStudent);
               theTeacher.subtractTardies(theStudent, 1);
               System.out.println("Tardy subtracted from " + notTardyStudent);
         });         
         
         //adds an absence to student record 
         //if successful, prints a message saying absence was added
      Button addAbsence = new Button("Add an Absence");
         grid4.add(addAbsence, 0, 6);
         addAbsence.setOnAction((action) -> {
            String absentStudent = addStudentName.getText();
            Student theStudent = h.get(absentStudent);
            theTeacher.addAbsences(theStudent, 2); 
            System.out.println("Absence added to " + absentStudent);
         });
         
         //removes an absence from student record 
         //if successful, prints a message saying absence was added
      Button subAbsence = new Button("Remove an Absence");
         grid4.add(subAbsence, 2, 6);
         subAbsence.setOnAction((action) -> {
            String notAbsentStudent = addStudentName.getText();
            Student theStudent = h.get(notAbsentStudent);
            theTeacher.subtractAbsences(theStudent, 2); 
            System.out.println("Absence removed from " + notAbsentStudent);
         });      
             
         //compares all students in a class to the max allowed amount of tardies (6)
         //if a student is over the max, prints a message saying over the max
         //if not, prints a message saying they are not over the max
      Button compareToCap = new Button("Compare all to Max");
         grid4.add(compareToCap, 0, 8);
         compareToCap.setOnAction((action) -> {
            String comparedStudent = addStudentName.getText();
            Student theStudent = h.get(comparedStudent);
            theTeacher.compareTOcap(theTeacher.attendanceList, 6);
         }); 
         
         //takes user back to teacher scene
      Button back = new Button("Back");
         grid4.add(back, 0, 10);
         back.setOnAction(e -> primaryStage.setScene(teacherScene));
         
/////////////////////////////////////////////////////////////////////////////////////////////
         
         //Student probation scene
         GridPane grid5 = new GridPane();
         probationScene = new Scene(grid5, 300, 200);
         Label label5 = new Label("Student probation");
         TextField probation = new TextField();
            grid5.add(probation, 0, 2);
            
            // user manually adds student to probation list 
            // if the student is over 6 tardies
         Button addProbation = new Button("Add Student to list");
            grid5.add(addProbation, 0, 4);
            addProbation.setOnAction((action) -> {
                String studentOnProbation = probation.getText();
                   Student studProb = h.get(studentOnProbation);
                theTeacher.addStudentProbation(studProb);
                System.out.println(studentOnProbation + " has been added to the probation list");
            });
            
            //manually removes student from the probation list
            Button removeProbation = new Button("Remove Student from list");
            grid5.add(removeProbation, 2, 4);
            removeProbation.setOnAction((action) -> {
                String studentOffProbation = probation.getText();
                Student removeStudProb = h.get(studentOffProbation);
                theTeacher.removeStudentProbation(removeStudProb);
                System.out.println(studentOffProbation + " has been removed from the probation list");
            });
                  
            //prints the information of everyone on the probation list 
            // if empty, prints a message saying it is empty 
         Button printProbation = new Button("Print Probation");
            grid5.add(printProbation, 0, 6);
            printProbation.setOnAction((action) -> {
               theTeacher.printProbation();
            });
     
            //empties the probation list
            //to be used at the end of a term 
         Button resetProbation = new Button("Reset Probation List");
            grid5.add(resetProbation, 2, 6);
            resetProbation.setOnAction((action) -> {
               theTeacher.resetList(theTeacher.probationList);
            });
            
            //takes user back to teacher scene
         Button backButton = new Button("Back");
            grid5.add(backButton, 0, 8);
            backButton.setOnAction(e -> primaryStage.setScene(teacherScene));
      
/////////////////////////////////////////////////////////////////////////////////////////////
      
      //DEAN SCENE
      GridPane grid3 = new GridPane();
      deanScene = new Scene(grid3, 300, 200);
      Label label4 = new Label("Dean Page");
         grid3.add(label4, 0, 0);
         
         //takes user to student subpage
      Button studentButton = new Button("Students");
         grid3.add(studentButton, 0, 4);
         studentButton.setOnAction(e -> primaryStage.setScene(deanStudent));
         
         //takes user to teacher subpage
      Button teacherButton = new Button("Teachers");
         grid3.add(teacherButton, 2, 4);
         teacherButton.setOnAction(e -> primaryStage.setScene(deanTeacher));
         
         //takes user back to homepage 
      Button allTheWayBack = new Button("Back");
         grid3.add(allTheWayBack, 0, 8);
         allTheWayBack.setOnAction(e -> primaryStage.setScene(scene));  
      
         
//////////////////////////////////////////////////////////////////////////////////////////////         
         
         //STUDENT SUBSCENE OF DEAN 
      GridPane grid6 = new GridPane();   
      deanStudent = new Scene(grid6, 300, 200);
      Label studentLabel = new Label("Enter the student's name");
         grid6.add(studentLabel, 0, 0);
      TextField studField = new TextField();
         grid6.add(studField, 0, 2);
         
         //prints the information of the student entered
      Button studentInfo = new Button("Student Info");
         grid6.add(studentInfo, 0, 4);
         studentInfo.setOnAction((action) -> {
             String studInfo = studField.getText();
             Student theStudent = h.get(studInfo);
             theStudent.printStudentInfo();
         });
                  
      Label move = new Label("To move a student");
         grid6.add(move, 0, 6);
      Label move2 = new Label("Add teachers to swap");
         grid6.add(move2, 0, 7);
      TextField teacher1 = new TextField();
         grid6.add(teacher1, 0, 8);
      TextField teacher2 = new TextField();
         grid6.add(teacher2, 2, 8);
      
         //retrieves the student object 
         //removes it from the first teacher's class in textbox 1
         //adds it to the class of the teacher in textbox 2
      Button moveStudent = new Button("Move Student");
         grid6.add(moveStudent, 0, 10);
         moveStudent.setOnAction((action) -> {
            String getStudentName = studField.getText();
               Student s1 = h.get(getStudentName);
            String T1string = teacher1.getText();
               Teacher moveT1 = hashTeacher.get(T1string);
            String T2string = teacher2.getText();
               Teacher moveT2 = hashTeacher.get(T2string);
            d1.moveStudent(moveT1, moveT2, s1);   
            System.out.println("Student " + s1 + " has been moved from " + T1string + " class to " + T2string + "class");
         });
         
         //takes user back to dean scene
      Button letsGoBack = new Button("Back");
         grid6.add(letsGoBack, 0, 12);
         letsGoBack.setOnAction(e -> primaryStage.setScene(deanScene));

      
///////////////////////////////////////////////////////////////////////////////////////////  
         
            //TEACHER SUBSCENE OF DEAN
         GridPane grid7 = new GridPane();
         deanTeacher = new Scene(grid7, 300, 200);
         
            //prints out the information of all teachers in the school
         Button printAllTeacher = new Button("All Teacher Info");
            grid7.add(printAllTeacher, 0, 2);
            printAllTeacher.setOnAction((action) -> {
               Chidi.printTeacherInfo();
               Seuss.printTeacherInfo();
            });
         
         Label enterTeacher = new Label("Enter Teacher");
            grid7.add(enterTeacher, 0, 6);    
         TextField selectTeacher = new TextField();
            grid7.add(selectTeacher, 0, 8);
            
            //prints the total amount of time all the students have missed 
            //in the entered teacher's class
         Button allMissedTime = new Button("Print the total missed Time");
            grid7.add(allMissedTime, 0, 10);
            allMissedTime.setOnAction((action) -> {
               String getTeacher = selectTeacher.getText();
               Teacher aTeacher = hashTeacher.get(getTeacher);
               System.out.println(getTeacher + " has a total missed time of: ");
                  aTeacher.allStudentsMissedTime();
            });
            
         Button compareTime = new Button("Compare Total Time");
            grid7.add(compareTime, 0, 12);
            compareTime.setOnAction((action) -> {
               d1.compareTeacherTotalTime();
            });
            
            //takes user back to dean scene
         Button goBack = new Button("Back");
            grid7.add(goBack, 0, 18);
            goBack.setOnAction(e -> primaryStage.setScene(deanScene));
         
         
///////////////////////////////////////////////////////////////////////////////////////////
     
      //makes the window visible 
      //should be the last thing before you implement your code 
      primaryStage.setScene(scene);
      primaryStage.show();
  
   }
}
