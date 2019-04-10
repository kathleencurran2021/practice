package attendanceProgram;
import java.util.*;
////////////////////////////////////////////////////////////////////////////////
// File:             Dean.java
// Course:           CSC232B, Spring 2019
// Authors:          (Carla, Kathleen, Sara, Tahj)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

/**
 * 
 */
public class Dean extends FacultyMember {
   private String name;
   private int age;
   private String department;
   private ArrayList<Teacher> tList;
   /*
    * Creates a new dean object with a name, age, and salary
    * department is always set to "Administration
    */
   
   public Dean (String name, int age, double salary) {
      // when creating a Dean, department will always be set to "Administration"
      this.name = name;
      this.age = age;
      this.department = "Administration";
      this.salary = salary;
      tList = new ArrayList<Teacher>(10);
   }
   public String getName() {
      return name; // returns the name
   }
   public int getAge() {
      return age; //returns the age
   }
   public String getDepartment() {
      return department; //returns the department
   }
   public double getSalary() {
      return salary; //returns the salary
   }
   /*
    * adds a teacher to the deans tList
    * @param teacher
    */
   public void addTeacher(Teacher t) {
      tList.add(t); 
   }
   /*
    * removes a teacher from the deans list
    * @param teacher
    */
   public void removeTeacher(Teacher t) {
      tList.remove(tList.indexOf(t));
   }
   /*
    * prints deans list of teachers
    */
   public void printTeacherList() {
      System.out.println("Currently employed Teachers");
      for(int i = 0; i < tList.size(); i++) {
         Teacher current = tList.get(i);
         current.printTeacherInfo();
      }
      System.out.println();
   }
   /*
    * prints deans list of teachers and their respective classes
    */
   public void printTeacherAttendanceList() {
      for(int i = 0; i <tList.size(); i++) {
         Teacher current = tList.get(i);
         current.printAttendance();
         System.out.println();
      }
   }
   /*
    * compares all teachers total missed time and gives a 10% raise to
    *  the person with the least totalMissed time and gives a warning
    *  to the teacher with the highest missed class time
    */
   public void compareTeacherTotalTime() {
      Teacher max = tList.get(0);
      for(int i =1; i < tList.size(); i++) {
         if(max.allStudentsMissedTime() < tList.get(i).allStudentsMissedTime())
            max = tList.get(i);
         else
            max = max;
      }
      Teacher min = tList.get(0);
      for(int i = 1; i < tList.size(); i++) {
         if(min.allStudentsMissedTime() > tList.get(i).allStudentsMissedTime())
            min = tList.get(i);
         else
            min = min;
      }
      System.out.println(max.getName()+ ". Lower your classes total missed time.");
      System.out.println(min.getName()+ ". You get a 10 percent raise.");
      double raise = min.getSalary() * .10;
      min.increaseSalary(raise);
      
   }
   /*
    * this takes three fields, it moves the student from one teacher 1
    * to teacher 2
    * @param teacher1
    * @param teacher2
    * @param student
    */
   public void moveStudent(Teacher t1, Teacher t2, Student s) {
      Student current = t1.getStudent(s);
      t1.removeStudent(s);
      t2.addStudent(current);
   }
   
   //deans list
   //Additonal attention List

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Dean d1 = new Dean("Marie Eleo", 44, 90234.90);
      Teacher Chidi = new Teacher("Chidi Anagonye", 36, "Philosophy", 55035.34);
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
      Teacher Seuss = new Teacher("Seuss Rol", 54, "Reading", 43692.73);
      Student Shaq = new Student("Shaq Lee", 13, 34212);
      Student Ryan = new Student("Ryan Benlow", 14, 93213);
      Student Marrissa = new Student("Marissa Hig", 17, 89132);
      Student Long = new Student("Long Kei", 16, 34211);
      Student Claire = new Student("Claire Lemon", 14 , 76459);
      Seuss.addStudent(Claire);
      Seuss.addStudent(Shaq);
      Seuss.addStudent(Marrissa);
      Seuss.addStudent(Long);
      Seuss.addStudent(Ryan);
      Seuss.addAbsences(Marrissa, 9);
      Seuss.addAbsences(Shaq, 4);
      Seuss.addAbsences(Long, 2);
      Seuss.addAbsences(Ryan, 5);
      Seuss.addAbsences(Claire, 10);
      Seuss.addTardies(Claire, 11);
      Seuss.addTardies(Marrissa, 3);
      Seuss.addTardies(Shaq, 0);
      Seuss.addTardies(Long, 6);
      Seuss.addTardies(Ryan, 3);
      Teacher Theresa = new Teacher("Theresa Ron", 21, "Math", 51500.01);
      Student Theo = new Student("Theo Harris", 12, 31224);
      Student Leo = new Student("Leo Agustus", 11, 32312);
      Student Lisa = new Student("Lisa Qig", 13, 42323);
      Student Xavier = new Student("Xavier Mind", 12, 90321);
      Theresa.addStudent(Lisa);
      Theresa.addStudent(Leo);
      Theresa.addStudent(Xavier);
      Theresa.addStudent(Theo);
      Theresa.addAbsences(Lisa, 12);
      Theresa.addAbsences(Xavier, 4);
      Theresa.addAbsences(Leo, 10);
      Theresa.addAbsences(Theo, 16);
      Theresa.addTardies(Lisa, 1);
      Theresa.addTardies(Xavier, 3);
      Theresa.addTardies(Theo, 13);
      Theresa.addTardies(Leo, 12);
      d1.addTeacher(Seuss);
   d1.addTeacher(Theresa);
      d1.addTeacher(Chidi);
  //d1.printTeacherList();
    //d1.printTeacherAttendanceList();
    //d1.moveStudent(Seuss, Chidi, Long);
    // d1.printTeacherAttendanceList();
   d1.compareTeacherTotalTime();
  // d1.printTeacherList();
   }

}
