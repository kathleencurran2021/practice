////////////////////////////////////////////////////////////////////////////////
// File:             Teacher.java
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
import java.util.*;

public class Teacher extends FacultyMember {
    private String name;
    private int age;
    private String department;
    //inherits the fields of Faculty Member plus an added attendance List(list of students)
    private static ArrayList <Student> attendanceList;
    private static ArrayList <Student> probationList;
    
    public Teacher(String name, int age, String department) { 
   this.name = name;
   if(age < 18)
       System.out.println("You are too young to work here.");
   else
       this.age = age;
   this.department = department;
   this.attendanceList = new ArrayList<Student>(30);
   this.probationList = new ArrayList<Student>(30);
    }
    public String getName() {
   return name;
    }
    public int getAge() {
   return age;
    }
    public String getDepartment() {
   return department;
    }
    public void addStudent(Student s) {
   attendanceList.add(s);
    }
    public void addStudentProbation(Student s) {
   probationList.add(s);
    }
    public void removeStudentProbation(Student s) {
   probationList.remove(probationList.indexOf(s));
    }
    public void removeStudent(Student s) {
   attendanceList.remove(attendanceList.indexOf(s));
    }
    public void printAttendance() {
   System.out.println("This is the class of "+getName());
   for(int index = 0; index < attendanceList.size(); index++) {
       Student current = attendanceList.get(index);
       current.printStudentInfo();
   }
   }
    public void printProbation() {
   if(this.probationList.size() == 0)
       System.out.println("The Probation List is empty, that is a good thing.");
   else {
   System.out.println("THIS IS THE PROBATION LIST.");
   System.out.println("TRY YOUR BEST TO GET OFF THIS LIST.");
   System.out.println("Come to class and study hard.");
   for(int index = 0; index < probationList.size(); index++) {
       Student current = probationList.get(index);
       current.printStudentInfo();
   }
   }
    }
    public void resetList(ArrayList<Student> list) {
   if(list.size() == 0)
       System.out.println("This list is empty.");
   else {
       list.clear();
       System.out.println("The list has been emptied.");
       System.out.println();
   }
    }
    public void addTardies(Student s, int amount) {
   s.addTOtardies(amount);
    }
    public void addAbsences(Student s, int amount) {
   s.addTOabsences(amount);
    }
    public void subtractTardies(Student s, int amount) {
   s.subtractTardies(amount);
    }
    public void subtractAbsences(Student s, int amount) {
   s.subtractAbsences(amount);
    }
    public void compareTOcap(ArrayList<Student> list, int cap){
   for(int index = 0; index < list.size(); index++) {
       Student current = list.get(index);
       if(current.getMissedClassTime() >= cap) {
      System.out.println("You have too much missed class time, " +current.getName());
      System.out.println("You will be put on probabtion.");
      System.out.println();
      addStudentProbation(current);
       }
   }
    }
    
    public static void main(String [] args) {
   Teacher Chidi = new Teacher("Chidi Anagonye", 36, "Philosophy");
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
   Chidi.printAttendance();
   Chidi.compareTOcap(attendanceList, 10);
   Chidi.resetList(probationList);
   Chidi.printProbation();
    }

   
            
}
