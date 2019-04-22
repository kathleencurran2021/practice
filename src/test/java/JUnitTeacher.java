import static org.junit.Assert.*;

import org.junit.Test;

import attendanceProgram.Student;
import attendanceProgram.Teacher;

////////////////////////////////////////////////////////////////////////////////
// File:             JUnitTeacher.java
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
public class JUnitTeacher {

   @Test
   public void test() {
      Teacher t = new Teacher("Ms.Black", 34, "Science", 45000.32);
      Student s = new Student("Sacls",12, 34232);
      t.addStudent(s);
      assertEquals(s, t.getStudent(s));
      String dept = t.getDepartment();
      assertNotEquals(dept, "Math");
    //  fail("Not yet implemented"); // TODO
   }

}
