import static org.junit.Assert.*;

import org.junit.Test;

import attendanceProgram.Dean;
import attendanceProgram.Student;
import attendanceProgram.Teacher;

////////////////////////////////////////////////////////////////////////////////
// File:             JUnitDean.java
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
public class JUnitDean {

   @Test
   public void test() {
      Student s = new Student("Sacls",12, 34232);
      Teacher t = new Teacher("Ms.Black", 34, "Science", 45000.32);
      Dean d = new Dean("Ms.Reed", 45, 60500);
      t.addStudent(s);
      d.addTeacher(t);
      String name = d.getName();
      assertEquals(name, "Ms.Reed");
    //  fail("Not yet implemented"); // TODO
   }

}
