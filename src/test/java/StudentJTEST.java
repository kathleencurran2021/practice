import static org.junit.Assert.*;

import org.junit.Test;

import attendanceProgram.Student;

////////////////////////////////////////////////////////////////////////////////
// File:             JUnitStudent.java
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
public class StudentJTEST {

   @SuppressWarnings("deprecation")
   @Test
   public void test() {
      Student s = new Student("Sacls",12, 34232);
     String check = "Sacls";
      assertEquals(check, "Sacls");
      assertEquals(s.getAbsences(), 0);
     // fail("Not yet implemented"); // TODO
   }

}
