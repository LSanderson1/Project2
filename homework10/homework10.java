/*************************************************************
//  NAME:        Lloyd Sanderson
//
//  HOMEWORK:    10
//  
//  CLASS:       ICS 212
//  
//  INSTRUCTOR:  Ravi Narayan
//  
//  DATE:        May 3, 2022
//
//  FILE:        homework10.java
//  
//  DESCRIPTION:
//   The java user interface portion of the is multiple 5 class
//   which uses JNI (Java Native Interface) and combines both Java
//   and C syntax in one source code. First loads the library in
//   which the C code is stored and runs from the native function the
//   is_multiple5 from there. The rest of the syntax is through Java.
//
***************************************************************/

import java.util.Scanner;
import java.util.InputMismatchException;

public class homework10 
{
    public static native int is_multiple5(int maxval);

    /*****************************************************************
    //  Function name: static (Library Loading)
    //
    //  DESCRIPTION:   Has the C Source code stored in here to be used
    //                 in print_table
    //
    //  Parameters:    none
    //
    //  Return values:  none
    //
    ****************************************************************/  
    static
    {
        System.loadLibrary("multiple");
    }
    
    /*****************************************************************
    //  Function name: main
    //
    //  DESCRIPTION:   Runs the user_interface, stores the value from
    //                 user_interface in val, and runs print_table with
    //                 that value
    //
    //  Parameters:    String args[]: The arguments given through the
    //                 compiler
    //
    //  Return values:  none
    //
    ****************************************************************/  
 
    public static void main(String args[])
    {
        int val = 0;
        val = user_interface();

        print_table(val);
    }
    
    /*****************************************************************
    //  Function name: user_interface
    //
    //  DESCRIPTION:   The user_interface which interacts with the user
    //                 to input a maximum value (includes error handling)
    //                 which is then to be printed through print_table
    //
    //  Parameters:    none
    //
    //  Return values:  maxval: the maximum value given by the user
    //
    ****************************************************************/  

    static int user_interface()
    {
        int maxval = 0;
        boolean control = true;
        Scanner input = new Scanner(System.in);
        
        System.out.print("This program takes a user value and prints all the ");
        System.out.print("multiples of 5 to the maximum value.\n");
        System.out.print("Please enter a maximum value: ");
        
        do
        {
            try
            {
                maxval = input.nextInt();
                control = false;
            }
            catch (InputMismatchException e)
            {
                System.out.print("Error, not a numeric integer.\n");
                input = new Scanner(System.in);
                System.out.print("Please enter a numeric integer: ");
            }
        } while(control != false);
        
        while (maxval < 0)
        {
            try
            {
                System.out.print("Error, not a positive integer.\n");
                input = new Scanner(System.in);
                System.out.print("Please enter a positive integer: ");
                maxval = input.nextInt();
            }
            catch (InputMismatchException e)
            {
                input = new Scanner(System.in);
            }
        }
        
        input.close();
        return maxval;
    }
    
    /*****************************************************************
    //  Function name: print_table
    //
    //  DESCRIPTION:   Prints out all the values from the maximum user
    //                 input that shows whether or not the number is 
    //                 divisible by 5 or not
    //
    //  Parameters:    maxval: the maximum value that was given by the user
    //
    //  Return values:  none
    //
    ****************************************************************/  
 
    static void print_table(int maxval)
    {
        String str = String.format("%s %18s", "Number", "Is Multiple 5?\n");
        System.out.print(str);
        for (int i = 0; i <= maxval; i++)
        {
            int multiple = is_multiple5(i);
            String str2 = "";
            if (multiple == 1)
            {
                str2 = String.format("%6d %16s", i, "Yes");
            }
            else
            {
                str2 = String.format("%6d %16s", i, "No");
            }
           System.out.println(str2);
        }
       
    }
}
