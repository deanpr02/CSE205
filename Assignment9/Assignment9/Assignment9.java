// Assignment: 9
// Name: Dean Prach 
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class will create a menu that will be able to choose from four recursive methods: finding the largest prime number, finding the sum of
// a group of even numbers, checking to see if a string is palindrome, or removing all instances of "A" from a string

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment9 {

    public static void main(String[] args) {
		
	char inputOpt = ' ';
    String inputLine;
    int results[];
    String str;




    try
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        do
        {
            
            printMenu();
            inputLine = stdin.readLine().trim();
            if(inputLine.isEmpty())
            {
                continue;
            }
            inputOpt = inputLine.charAt(0);

            switch(inputOpt)
            {
                //Find the largest prime number in an array of integers
                case '1':
                results = parseInts(stdin);
                System.out.print("The largest prime number in the array is: " + largestPrime(results, results.length - 1,0) + "\n");
                break;

                //Find the largest even number in an array of integers
                case '2':
                results = parseInts(stdin);
                System.out.print("The sum of all even numbers in the array is: " + sumAllEven(results, results.length - 1, 0) + "\n");
                break;

                //Determine whether a string is palindrome or not
                case '3':
                System.out.print("Please enter String:\n");
                str = stdin.readLine();
                System.out.print("Palindrome test result is: " + isPalindrome(str, 0, str.length() - 1, false ) + "\n");
                break;

                //Remove all instances of a character from a string
                case '4':
                System.out.print("Please enter String:\n");
                str = stdin.readLine();
                System.out.print("String after removing all occurrences of character \"A\": " + removeCharacter(str,'A',0) + "\n");
                break;

                //Quit the program
                case '5':
                break;

                default:
                System.out.print("Unknown action\n");
                break;
    }
    } while(inputOpt != '5' || inputLine.length() !=1);
    }
    catch(IOException e){
        System.out.print("IO Exception");
    }
    }
    // Utility method for printing the menu 
    public static void printMenu() {
        System.out.print("\nWhat would you like to do?\n\n");
        System.out.print("1: Find the largest prime number in an array of integers\n");
        System.out.print("2: Calculate the sum of all even numbers in an array of integers\n");
        System.out.print("3: Check if a string is palindrome or not\n");
        System.out.print("4: Remove all occurrences of character \"A\" in a String\n");
        System.out.print("5: Quit\n\n");
    }

    // utility method for parsing integers from standard input
    public static int[] parseInts(BufferedReader reader) 
    {
        String line = "";
        ArrayList<Integer> container = new ArrayList<>();
        try 
        {
            System.out.print("Please enter integers:\n");
            line = reader.readLine();
            int num = Integer.parseInt(line);

            while (num > 0) 
            {
                container.add(num);
                line = reader.readLine();
                num = Integer.parseInt(line);
            }

        } 
        catch (IOException ex) 
        {
            System.out.println("IO Exception");
        }

        int[] result = new int[container.size()];
        for(int i = 0; i < container.size(); i++)
        {
            result[i] = container.get(i);
        }
        return result;
    }
    //Method whichs returns the largest prime number stored in an array; returns zero if
    //there are no prime numbers
    public static int largestPrime(int arr[], int index, int max)
    {
        if(index == -1){
            return(max);
        }
        else if(findPrimeNumber(arr[index]) && arr[index] > max){
            max = arr[index];
            return(largestPrime(arr, index - 1, max));
        }
        else
        {
            return(largestPrime(arr,index - 1, max));
        }
        }
    //Method which returns true if an integer is a prime number and false if it is not a prime number
    public static boolean findPrimeNumber(int n){
        int i = 2;
        boolean result = true;
        if(n % 2 == 0){
            return false;
        }
        else
        {
            while(i < n){
                if(n % i == 0){
                    result = false;
                    break;
                }
                i++;
            }

        }
        return result;
    }
    //Method which returns the sum of all even integers in an array
    public static int sumAllEven(int arr[], int index, int sum)
    {
        if(index == -1){
            return (sum);
        }
        else if(arr[index] % 2 == 0)
        {
            sum = sum + arr[index];
            return(sumAllEven(arr,index - 1, sum));
        }
        else{
            return(sumAllEven(arr, index - 1, sum));
        }
    }
    //Method that returns true if a string is palindrome and returns false if it is not
    public static boolean isPalindrome(String str, int start, int end, boolean answer){
        if(start >= end)
        {
            return(answer);
        }
        else if(str.charAt(start) == str.charAt(end))
        {
        answer = true;
        return(isPalindrome(str, start + 1, end - 1, answer));
        }
        else{
            return(false);
        }
    }
    //Method removes all instances of a character 'A' within a string
    public static String removeCharacter(String str, char character, int index){
        if(index == str.length())
        {
            return(str);
        }
        else if(str.charAt(index) == character)
        {
            str = str.substring(0,index) + str.substring(index + 1);
            if(index != 0){
            index--;  
            }
            return(removeCharacter(str, character, index));
        }
        else{
            index++;
            return(removeCharacter(str, character, index));

        }
    }
}

