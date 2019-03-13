
/*
The class "CustomerTestDriver" holds the main that create two
Customer Objects; "Brian" and "Tahj". The method toString() is 
called on each object, printing out all the fields of both.
 */

/*
File : CustomerTestDriver.java
Course : CSC232
Author(s) : Tahj Dosso
 */

import java.util.*;

public class CustomerTestDriver {
    /*
      The <code>CustomerTestDriver</code> makes an two instances of a Customer and prints them out
     */
    
    public static void main(String [] args) {
	Customer Brian = new Customer("Brian Howard", 53, 1230, 6375.53);
	System.out.println(Brian.toString());
	Customer Tahj = new Customer("Tahj Dosso", 19, 1130, 525.32);
	System.out.println(Tahj.toString());
	Tahj.changeAge(128);
	System.out.println(Tahj.toString());
	 
    }

}
