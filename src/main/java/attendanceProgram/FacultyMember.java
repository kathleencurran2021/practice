package attendanceProgram;
////////////////////////////////////////////////////////////////////////////////
// File:             FacultyMember.java
// Course:           CSC232B, Spring 2019
// Authors:          (Kathleen, Carla, Sarah, Tahj)
//
// Acknowledgements:
//
// Online sources:   (stackoverflow.com)
////////////////////////////////////////////////////////////////////////////////

/**
 * 
 */
public abstract class FacultyMember {
   /*

    */
       private String name;// name for faculty
       private int age; // age for faculty
       private String department; // department for faculty
       public double salary; // pay for faculty

       public abstract String getName(); // gets name
       public abstract int getAge(); //gets name
       public abstract String getDepartment();// gets department
       public abstract double getSalary(); // gets salary
       

}
