// 7. Take a String input that contains multiple words. Do the following: i) number of times ‘a’ appears ii) 
// number of times “and” appears iii) whether it starts with “The” or not iv) put the String into an 
// array of characters v) display the tokens in the String (tokens are the substrings separated by space 
// or @ or .) vi)Find the largest palindrome in a given input sentence after removing any non-
// alphanumeric character. 

import java.util.Arrays;
import java.util.Scanner;

public class StringPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        int c=0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='a')
                c++;
        }

        System.out.println("Number of a = "+c);

        // calculate number of "and" substrings
        int count = 0;
        String target = "and";
        for (int i = 0; i <= str.length() - target.length(); i++) {
            if (str.substring(i, i + target.length()).equals(target)) {
                count++;
            }
        }
        System.out.println("Number of 'and' = " + count);

        // check if string starts with "The"
        boolean startsWithThe = str.startsWith("The");
        System.out.println("Starts with 'The': " + startsWithThe);

        // put string into array of characters
        char[] charArray = str.toCharArray();
        System.out.println("Character array: " + Arrays.toString(charArray));

        // display tokens in the string
        String[] tokens = str.split("[ @.]+");
        System.out.println("Tokens: " + Arrays.toString(tokens));

        sc.close();
    }    
}