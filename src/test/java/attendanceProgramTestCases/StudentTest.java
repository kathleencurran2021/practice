////////////////////////////////////////////////////////////////////////////////
// File:             StudentTest.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package attendanceProgramTestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import attendanceProgram.Student;

/**/
 
 
public class StudentTest {
      Student s = new Student("TestName", 12, 84212);
   /**
    * Test method for {@link attendanceProgram.Student#addTOabsences(int)}.
    */
   @Test
   public void testAddTOabsences() {
      s.addTOabsences(2);
      int two = 2;
      assertEquals(2, s.getAbsences());
     // if(s.getAbsences() != 2)
   //   fail("This fails"); // TODO
   }

   /**
    * Test method for {@link attendanceProgram.Student#addTOtardies(int)}.
    */
   
   @Test
   public void testAddTOtardies() {
      s.addTOtardies(3);
      if(s.getTardies() != 1.5)
         fail("This fails");
      }

   /**
    * Test method for {@link attendanceProgram.Student#subtractAbsences(int)}.
    */
   @Test
   public void testSubtractAbsences() {
      s.subtractAbsences(2);
      int z = 0;
      assertEquals(z, s.getAbsences());
     
   }

   /**
    * Test method for {@link attendanceProgram.Student#subtractTardies(int)}.
    */
   @SuppressWarnings("deprecation")
   @Test
   public void testSubtractTardies() {
      s.subtractTardies(3);
     if(s.getTardies() != 0)
     fail("This fails"); // TODO
   }

  

}
