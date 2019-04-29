////////////////////////////////////////////////////////////////////////////////
// File:             DeanTest.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package attendanceProgram;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */
public class DeanTest {
   Student s = new Student("TestName", 12, 84212);
   Teacher t = new Teacher("TeacherTest", 34, "Science", 1000.00);
   Teacher t2 = new Teacher("TeacherTest2", 32, "Math", 1000.00);
   Dean d = new Dean("DeanTest", 42, 21212.00);
   
   /**
    * Test method for {@link attendanceProgram.Dean#addTeacher(attendanceProgram.Teacher)}.
    */
   @Test
   public void testAddTeacher() {
      d.addTeacher(t2);
      if(d.getTeacher(t2) != t2)
      fail("Not yet implemented"); // TODO
   }

   /**
    * Test method for {@link attendanceProgram.Dean#removeTeacher(attendanceProgram.Teacher)}.
    */
   @Test
   public void testRemoveTeacher() {
      d.removeTeacher(t2);
      try {
         d.getTeacher(t2);
      }
      catch(ArrayIndexOutOfBoundsException e) {
      
      }
      
    //  if(d.getTeacher(t2) == t2)
    //  fail("Not yet implemented"); // TODO
   }

   /**
    * Test method for {@link attendanceProgram.Dean#moveStudent(attendanceProgram.Teacher, attendanceProgram.Teacher, attendanceProgram.Student)}.
    */
   @Test
   public void testMoveStudent() {
      t.addStudent(s);
      d.moveStudent(t, t2, s);
      if(t2.getStudent(s) != s)
      fail("Not yet implemented"); // TODO
   }

}
