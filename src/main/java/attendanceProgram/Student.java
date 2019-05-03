package attendanceProgram;
////////////////////////////////////////////////////////////////////////////////
// File:             Student.java
// Course:           CSC232B, Spring 2019
// Authors:          (Tahj, Carla, Sara, Kathlenn)
//
// Acknowledgements: 
//      
//
// Online sources:   (stackoverflow.com)
////////////////////////////////////////////////////////////////////////////////

public class Student {

    private String name;// name of a student
    private int grade; // this is the students grade level. For the  sake of simulation  student objects may all have same grade level
    private int idNumber; //no more than five digits (ex: 00001) 
    public int absences; //Counts as a missed class period
    public double tardies; // A tardy is being late to a class session. Two tardies equals one absence. (2:1)
    public double missedClassTime; //This is the summation of tardies and absences

    /*
      Constructor creates a student object with a passing of
      A name, a grade, and ID number.
      Absences, tardies, and MissedClassTime will be set to
      zero.
     */
    public Student(String name, int grade, int idNumber) {
   this.name = name;
   this.grade = grade;
   this.idNumber = idNumber;
   this.absences = 0;
   this.tardies = 0.0;
   this.missedClassTime = 0.0;
    }
    public String getName() {
   return name; // returns name
    }
    public int getGrade() {
   return grade; // returns grade
    }
    public int getIdNumber() {
   return idNumber; //returns idNumber 
    }
    public int  getAbsences() {
   return absences; //returns absences
    }
    public double getTardies() {
   return tardies; //returns tardies
    }
    public double getMissedClassTime() {
   return missedClassTime; //returns missedClasstime
    }
    /* 
       The "addTOabsences" method, adds what value is passed as increase to
       a students total absence. 
       */
    public void addTOabsences(int increase) {
       absences = absences +  increase;
       totalMissedTime();  
    }
    /*
      The "addTOtardies" method adds" increase" to the total
      amount of a students tardies count
     */
    public void addTOtardies(int increase){
   double add = ((double) increase) / 2.0;
        tardies = tardies + add;
        totalMissedTime();
    }
    /*
      This method calculates the total missed time a student has.
      Returns the total missed time.
      Missed is equal to absences plus tardies
     */
    public void totalMissedTime() {
   this.missedClassTime = this.getAbsences() + this.getTardies();
   
    }
    /*
     * This method subtracts variable "decrease" from the students absence
     * totalMissedTime()
     * @param decrease
     */
    public void subtractAbsences(int decrease) {
   if(decrease > this.getAbsences())
       System.out.println("You can not subtract a greater amount of absences from a students total absences.");
   else
   absences = absences - decrease;
   totalMissedTime();
    }
    /*
     * This method subtracts variable "decrease" from the students tardies
     * totalMissedTime() works as an invariance
     * @param decrease
     */
    public void subtractTardies(int decrease) {
   double sub = (((double) decrease) / 2.0 );
        if(sub > this.getTardies()) 
       System.out.println("You can not subtract a greater amount of tardies from a students total tardies.");
   else
       tardies = tardies - sub;
        totalMissedTime();
}
    /*
     * prints student info(all of their fields)
     */
    public Student getStudent(Student s) {
       return s; // return student
    }
    
    public void printStudentInfo() {
   totalMissedTime();
   System.out.println("******************");
   System.out.println("Student's name -> " +getName());
   System.out.println("Student's grade -> " +getGrade());
   System.out.println("Student ID number -> " +getIdNumber());
   System.out.println("Student Absences -> " +getAbsences());
   System.out.println("Student Tardies -> " +getTardies());
   System.out.println("Total Missed Class Time -> " +getMissedClassTime());
   System.out.println("******************");
   System.out.println();
    }
   /*
   public static void main(String [] args) {
       Student loki = new Student("Loki" , 12 , 62321);
       Student Derrick = new Student("Derrick", 14, 67823);
       Student Hayden = new Student("Hayden", 13, 42361);
       loki.addTOtardies(3);
       loki.addTOabsences(6);
       loki.subtractAbsences(1);
       loki.printStudentInfo();
       Derrick.addTOtardies(4);
       Derrick.addTOabsences(5);
       Derrick.printStudentInfo();
       Hayden.addTOtardies(2);
       Hayden.addTOabsences(9);
       Hayden.printStudentInfo();
   }
   */
}




