// Assignment #: 2
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF 10:10-11:00
//  Description: This class reads a sequence of integers until it reads the value '0' from a keyboard and prints out
//               the minimum value, largest even integer, the sum of all positive integers, and the count of odd integers.

import java.util.Scanner;
public class Assignment2{
//The main method reads a value from the keyboard and sets it as the minimum value, then the while loop will check to see if the value is odd and if it
// is odd then it will add to the variable count, then it checks if the value is even and if it is it checks to see if it is the biggest value, and then it
// adds all the positive integers together. The loop will continue to run until the value '0' is read.
    public static void main(String[] args){
            Scanner scnr = new Scanner(System.in);
            int num = scnr.nextInt();
            int min = num;
            int sum = 0;
            int largeEven = 0;
            int count = 0;
            while(num != 0){
                if(num <= min){
                    min = num;
                }   
                if(num % 2 != 0){
                    count++;
                } 
                if(num % 2 == 0 && largeEven <= num){
                    largeEven = num;
                }
                if(num > 0){
                    sum += num;
                }
                num = scnr.nextInt();

            }
            System.out.println("The minimum integer is " + min);
            System.out.println("The count of odd integers in the sequence is " + count);
            System.out.println("The largest even integer in the sequence is " + largeEven);
            System.out.println("The sum of positive integers is " + sum);

    }

}