import java.util.*;
////////////////////////////////////////////////////////////////////////////////
// File:             TestDriver.java
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
public class TestDriver {

   /**
    * @param args
    */
   
   public static void main(String[] args) {
      ArrayList <Student> attendanceList = new ArrayList<Student>(30);
      ArrayList <Student> probationList = new ArrayList<Student>(30);
      
      Teacher Chidi = new Teacher("Chidi Anagonye", 36, "Philosophy", 50000.0);
      Student Tahj = new Student("Tahj Dosso", 14, 34512);
      Student Derrick = new Student("Derrick Ousley" , 14, 57238);
      Student Nadia = new Student("Nadia Lino", 15, 26172);
      Student Eleanor = new Student("Eleanor ShellStrop", 15, 34671);
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
      //Chidi.printAttendance();
      Chidi.compareTOcap(attendanceList, 4);
     // Chidi.resetList(probationList);
      Chidi.printProbation();
      

   }

}
