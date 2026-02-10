// 7. Take a String input that contains multiple words. Do the following: i) number of times ‘a’ appears ii) 
// number of times “and” appears iii) whether it starts with “The” or not iv) put the String into an 
// array of characters v) display the tokens in the String (tokens are the substrings separated by space 
// or @ or .) vi)Find the largest palindrome in a given input sentence after removing any non-
// alphanumeric character. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringPattern {

    static List<String> getStringTokens(String str) {
        String s="";
        List<String> tokens=new ArrayList<>();

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i)==' ' || str.charAt(i)=='@' || str.charAt(i)=='.') {
                tokens.add(s);
                s="";
            } else {
                s+=str.charAt(i);
            }
        }
        tokens.add(s);
        return tokens;
    }

    static boolean isPalindrome(String str) {
        int i=0, j=str.length()-1;

        while (i<j) {
            if (str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static String largestPalindrome(String str) {
        String newStr="";

        for (int i=0; i<str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i)) || Character.isWhitespace(str.charAt(i))) {
                newStr+=str.charAt(i);
            } else {
                newStr+=' ';
            }
        }

        List<String> tokens=getStringTokens(newStr);
        int max=0;
        String largestPalindrome="";

        for (int i=0; i<tokens.size(); i++) {
            String cmp=tokens.get(i);
            if (isPalindrome(cmp) && cmp.length()>max) {
                max=cmp.length();
                largestPalindrome=cmp;
            }
        }

        return (max==0)?"No palindrome Strings":largestPalindrome;
    }

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
        System.out.print("Tokens: ");
        List<String> tokens=getStringTokens(str);
        System.out.print(tokens.toString());

        System.out.println();

        // find the larget palindrome
        String largestPalindrome=largestPalindrome(str);
        System.out.print("Largest Palindrome: ");
        System.out.print(largestPalindrome);

        System.out.println();

        sc.close();
    }    
}