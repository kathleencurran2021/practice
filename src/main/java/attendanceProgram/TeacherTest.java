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

package attendanceProgram;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */
public class TeacherTest {
   Student s = new Student("TestName", 12, 84212);
   Student s1 = new Student("TestName2", 12, 32312);
   Teacher t = new Teacher("TeacherTest", 34, "Science", 1000.00);
   /**
    * Test method for {@link attendanceProgram.Teacher#increaseSalary(double)}.
    */
   @Test
   public void testIncreaseSalary() {
      t.increaseSalary(1000.00);
      if(t.getSalary() != 2000.00)
      fail("This fails"); // TODO
      t.decreaseSalary(1000.00);
   }

   /**
    * Test method for {@link attendanceProgram.Teacher#decreaseSalary(double)}.
    */
   @Test
   public void testDecreaseSalary() {
      t.decreaseSalary(1000.00);
      if(t.getSalary() != 0.00)
      fail("Not yet implemented"); // TODO
      t.increaseSalary(1000.00);
   }

   /**
    * Test method for {@link attendanceProgram.Teacher#addStudent(attendanceProgram.Student)}.
    */
   @Test
   public void testAddStudent() {
      t.addStudent(s);
      if(t.getStudent(s) != s)
      fail("Not yet implemented"); // TODO
   }
   /**
    * Test method for {@link attendanceProgram.Teacher#removeStudent(attendanceProgram.Student)}.
    */
   @Test
   public void testRemoveStudent() {
      t.addStudent(s);
      t.addStudent(s1);
      t.removeStudent(s);
      
      
      if(attendanceList.size() )
      try { 
         t.getStudent(s);
         fail("Not yet implemented"); // TODO
      }
      catch (ArrayIndexOutOfBoundsException arr) {
      }// if(t.getStudent(s) != null)
      
   }

   /**
    * Test method for {@link attendanceProgram.Teacher#allStudentsMissedTime()}.
    */
   @Test
   public void testAllStudentsMissedTime() {
      t.addStudent(s);
      t.addTardies(s, 2);
      t.addAbsences(s, 1);
      if(t.allStudentsMissedTime() != 2)
      fail("Not yet implemented"); // TODO
      t.subtractAbsences(s, 1);
      t.subtractTardies(s, 2);
   }

   /**
    * Test method for {@link attendanceProgram.Teacher#addTardies(attendanceProgram.Student, int)}.
    */
   @Test
   public void testAddTardies() {
      t.addTardies(s, 2);
      if(s.getTardies() != 1)
      fail("Not yet implemented"); // TODO
   }

   /**
    * Test method for {@link attendanceProgram.Teacher#addAbsences(attendanceProgram.Student, int)}.
    */
   @Test
   public void testAddAbsences() {
      t.addAbsences(s, 1);
      if(s.getAbsences() != 1)
      fail("Not yet implemented"); // TODO
   }

   /**
    * Test method for {@link attendanceProgram.Teacher#subtractTardies(attendanceProgram.Student, int)}.
    */
   @Test
   public void testSubtractTardies() {
      t.subtractTardies(s, 2);
      if(s.getTardies() == 1)
      fail("Not yet implemented"); // TODO
   }

   /**
    * Test method for {@link attendanceProgram.Teacher#subtractAbsences(attendanceProgram.Student, int)}.
    */
   @Test
   public void testSubtractAbsences() {
      t.subtractAbsences(s, 1);
      if(s.getAbsences() == 1)
      fail("Not yet implemented"); // TODO
   }

}
