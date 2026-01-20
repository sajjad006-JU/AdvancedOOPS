// 4. Write a program that accepts a String and assigns it to another. Check the outcome of 
// comparison with == and equals() method. Take two Strings and put same input for them. Repeat the 
// equality checking. Observe the outcome. 
// Sajjad Ahmed Shaaz, 002410501093

import java.util.*;
public class StringComparison {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        String s1;
        System.out.println("Enter a string: ");
        s1=sc.nextLine();

        String s2;
        System.out.println("Enter another string to compare: ");
        s2=sc.nextLine();

        if (s1==s2)
            System.out.println("s1==s2 -> true");
        else
            System.out.println("s1==s2 -> false");
        System.out.println("s1.equals(s2) -> " + s1.equals(s2));
        
        String s3=s2;

        if (s2==s3)
            System.out.println("s2==s3 -> true");
        else
            System.out.println("s2==s3 -> false");
        System.out.println("s2.equals(s3) -> " + s2.equals(s3));
        
    }    
}
