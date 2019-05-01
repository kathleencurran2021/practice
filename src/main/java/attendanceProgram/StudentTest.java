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

package attendanceProgram;

import static org.junit.Assert.*;

import org.junit.Test;

/**/
 *
 */
public class StudentTest {
      Student s = new Student("TestName", 12, 84212);
   /**
    * Test method for {@link attendanceProgram.Student#addTOabsences(int)}.
    */
   @Test
   public void testAddTOabsences() {
      s.addTOabsences(2);
      if(s.getAbsences() != 2)
      fail("This fails"); // TODO
   }

   /**
    * Test method for {@link attendanceProgram.Student#addTOtardies(int)}.
    */
   @Test
   public void testAddTOtardies() {
      s.addTOtardies(3);
      if(s.getTardies() != 1.5)
      fail("This fails"); // TODO
   }

   /**
    * Test method for {@link attendanceProgram.Student#subtractAbsences(int)}.
    */
   @Test
   public void testSubtractAbsences() {
      s.subtractAbsences(2);
      if(s.getAbsences() != 0)
      fail("This fails"); // TODO
   }

   /**
    * Test method for {@link attendanceProgram.Student#subtractTardies(int)}.
    */
   @Test
   public void testSubtractTardies() {
      s.subtractTardies(3);
      if(s.getTardies() != 0)
      fail("This fails"); // TODO
   }

  

}
