package attendanceProgramUI;
import static org.junit.Assert.*;

import org.junit.Test;

import attendanceProgram.Teacher;

////////////////////////////////////////////////////////////////////////////////
// File:             TeacherTest.java
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
public class TeacherTest {
Teacher teacher1 = new Teacher("Ms.Bronson", 32, "Education", 50000.0);

   /**
    * Test method for {@link Teacher#getDepartment()}.
    */
   @Test
   public void testGetDepartment() {
     String expected = teacher1.getDepartment();
      String result = "Education";
      assertEquals(expected, result);
      // TODO
   }

}
