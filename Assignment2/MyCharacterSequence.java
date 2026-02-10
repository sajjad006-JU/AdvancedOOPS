import java.util.Scanner;

public class MyCharacterSequence implements CharSequence {

    private final char[] data;

    public MyCharacterSequence(String source) {
        String reverse="";

        for (int i=source.length()-1; i>=0; i--) {
            reverse+=source.charAt(i);
        }
        this.data=reverse.toCharArray();
    }
    
    public char charAt(int index) {
        return data[index];
    }

    public int length() {
        return data.length;
    }

    public CharSequence subSequence(int start, int end) {
        return this.toString().subSequence(start, end);
    }

    public String toString() {
        String newStr="";

        for (int i=0; i<data.length; i++) {
            newStr+=data[i];
        }
        return newStr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a string into my character sequence : ");
        String str=sc.nextLine();


        MyCharacterSequence mcs=new MyCharacterSequence(str);
        
        System.out.println("Char At 0 = "+mcs.charAt(0));
        System.out.println("Length : "+mcs.length());
        System.out.println("Subsequence 0, 2: "+mcs.subSequence(0, 2));
        System.out.println("toString = "+mcs.toString());
    }
}
