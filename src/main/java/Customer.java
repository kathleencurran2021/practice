/*
After implementing the needed fields(name,age,arrival time),
 I decided to add a balance to the customer. I deemed it
logical for a customer to have a balance.
Accessor methods for all the fields, and mutator methods for balance
and age.
Within my toString() method I used command "\n" to receive a new line
after field was printed out.
 */

////////////////////////////
//File : Customer.java    //
//Course : CSC232         //
//Author(s) : Tahj Dosso  //
////////////////////////////


import java.util.*;
import java.lang.*;

public class Customer {

    private static String name;
    private static int age;
    private static int arrivalTIme;
    private static double balance; //A customer would have a balance.

    /*
      The <code>Customer</code> creates a Customer object
      
      @author Tahj Dosso <tahjdosso_2021@depauw.edu>
     */
    
    //Customer class with age,name ,arrival time, and balance
    public Customer(String name,int age, int arrivalTime, double balance) {   
	this.name = name;
	this.age = age;
	this.arrivalTIme = arrivalTime;
	this.balance = balance;
    }

    public static String getName() {
 
	return name;
	//returns the name

    }
    public static int getAge() {
       
	return age;
	//return age

    }
    public static int getArrivalTime() {
	return arrivalTIme;
	//returns arrival time;
	
    }
    public static double getBalance() {
	return balance;
	//returns balance
//poop
    }
    public static void changeName(String newName) {
	name = newName;
	// changes "name" to "newName"
    }
    public static void changeAge(int newAge) {
	if(newAge > 127)
	    System.out.println("Wow you're old, " + getName());
	age = newAge;
	//checks if age is greater than 127 and updates
    }
    public String toString() {
	return "Name : " +this.name + " \nAge : " +this.age + "\nArrival Time : " +this.arrivalTIme + "\nBalance : " + this.balance+  "\n";
	    
    }





}