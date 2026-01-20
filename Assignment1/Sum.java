// 1. Write a program to accept two short integers from user and display the sum.  
// Check what happens when the sum exceeds the maximum range of short.
// Sajjad Ahmed Shaaz, 002410501093

import java.util.*;

public class Sum {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        short s1, s2;
    
        System.out.println("Enter two short integers: ");
        s1=sc.nextShort();
        s2=sc.nextShort();
        short sum=(short) (s1+s2);

        System.out.println("Sum = "+sum);
        sc.close();
    }
    
}

// when sum exceeds the maximum value it resets to the minimum value of short data type,\
// for eg: max value of short is 32767,
// so 32767+1 = -32768 (minimum value of short)