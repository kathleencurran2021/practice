package attendanceProgram;
////////////////////////////////////////////////////////////////////////////////
//
// Course:           CSC232B, Spring 2019
// Authors:          (Sara, Carla, Tahj, Kathleen)
//
// Acknowledgements: 
//
// Online sources:   (stackoverflow.com)
////////////////////////////////////////////////////////////////////////////////

/**
 * 
 */
import java.util.*;
import java.text.DecimalFormat;

public class Teacher extends FacultyMember {
    private String name;
    private int age;
    private String department;
    private double salary;
    //inherits the fields of Faculty Member plus an added attendance List(list of students)
    private ArrayList <Student> attendanceList; // list that holds a teachers student
    private ArrayList <Student> probationList;// list that holds probation student
    private static DecimalFormat twoDECI = new DecimalFormat(".##");
    /*
     * Constructor creates new teacher
     * With name, age, department, and salary
     */
    public Teacher(String name, int age, String department, double salary) { 
   this.name = name;
   if(age < 18)
       System.out.println("You are too young to work here.");
   else
       this.age = age;
   this.department = department;
      if(salary > 60000.00)
         System.out.println("I believe you have the capaibilites, but we do not have the money.");
      else
         this.salary = salary;
   this.attendanceList = new ArrayList<Student>(30);
   this.probationList = new ArrayList<Student>(30);
    }
    public String getName() {
   return name;// returns name
    }
    public int getAge() {
   return age;// returns age
    }
    public String getDepartment() {
   return department;// returns department
    }
    public double getSalary() {
       return salary;// returns salary 
    }
    /*
     * this method increases the salary by the argument -> amount
     * @param amount
     */
    public void increaseSalary(double amount) {
       salary = salary + amount;
    }
    /*
     * this method decrease the salary by the argument -> amount
     * if the amount is less than the total salary, prints "error" message
     * @param amount
     */
    public void decreaseSalary(double amount) {
       if(amount > this.salary)
          System.out.println("You can not decrease a salary more than the amount!");
       else
          salary = salary - amount;
    }
    /*
     * print Teacher's info
     */
    public void printTeacherInfo() {
       System.out.println("****************");
       System.out.println("Teacher's Name: " +getName());
       System.out.println(getName()+"'s"+ " Age: " +getAge());
       System.out.println(getName()+"'s"+ " Department: " +getDepartment());
       System.out.println(getName()+"'s"+" Salary: $" +twoDECI.format(getSalary()));
       System.out.println("****************");
       System.out.println();
    }
    /*
     * adds a student to the attendance list
     * @param student
     */
    public void addStudent(Student s) {
   attendanceList.add(s);
    }
    /*
     * adds a student to the probation list
     * @param student
     */
    public void addStudentProbation(Student s) {
   probationList.add(s);
    }
    /*
     * removes student from probation list
     * @param student
     */
    public void removeStudentProbation(Student s) {
   probationList.remove(probationList.indexOf(s));
    }
    /*
     * removes student from attendance list
     * @param student
     */
    public void removeStudent(Student s) {
   attendanceList.remove(attendanceList.indexOf(s));
    }
    
    public Student getStudent(Student s) {
       return s; // return student
    }
    /*
     * prints a teachers attendance list
     */
    public void printAttendance() {
   System.out.println("This is the class of "+getName());
   for(int index = 0; index < attendanceList.size(); index++) {
       Student current = attendanceList.get(index);
       current.printStudentInfo();
   }
   }
    /*
     * adds all the students missed time and returns the value
     */
    public double allStudentsMissedTime() {
       double sum = 0;
       for(int i = 0; i < attendanceList.size(); i++) {
          Student current = attendanceList.get(i);
          sum += current.getMissedClassTime();
       }
       return sum;
    }
    /*
     * print probation list 
     */
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
    // resets list
    public void resetList(ArrayList<Student> list) {
   if(list.size() == 0)
       System.out.println("This list is empty.");
   else {
       list.clear();
       System.out.println("The list has been emptied.");
       System.out.println();
   }
    }
    /*
     * add tardies to a student
     * @param student
     * @param amount
     */
    public void addTardies(Student s, int amount) {
   s.addTOtardies(amount);
    }
    /*
     * add absences to a student
     * @param student
     * @param amount
     */
    public void addAbsences(Student s, int amount) {
   s.addTOabsences(amount);
    }
    /*
     * subtract tardies from a student
     * @param student
     * @param amount
     */
    public void subtractTardies(Student s, int amount) {
   s.subtractTardies(amount);
    }
    /*
     * subtract absences from a student
     * @param student
     * @param amount
     */
    public void subtractAbsences(Student s, int amount) {
   s.subtractAbsences(amount);
    }
    /*
     * this method takes a list and compares the students missed
     * time to a cap value. All that surpass cap are moved to the 
     * probation list.
     */
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
   Teacher Chidi = new Teacher("Chidi Anagonye", 36, "Philosophy", 55035.34);
   Student Tahj = new Student("Tahj Dosso", 14, 34512);
   Student Derrick = new Student("Derrick Ousley" , 14, 57238);
   Student Nadia = new Student("Nadia Lino", 15, 26172);
   Student Eleanor = new Student("Eleanor ShellStrop", 15, 34671);
   Chidi.printTeacherInfo();
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
   Chidi.allStudentsMissedTime();
   Chidi.getStudent(Eleanor);
   //Chidi.printAttendance();
  //Chidi.compareTOcap(attendanceList, 4);
   //Chidi.resetList(probationList);
 //Chidi.printProbation();

    }

   
            
}
