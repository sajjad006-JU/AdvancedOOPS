// 3. Input n and consider an array of 1 to n natural numbers. Skip every second value and print the 
// resulting series. Then select every third value from the remaining numbers. Print the resulting series. 
// Repeat this process till the skip count becomes greater than the length of the list. 
// {1,2,3,4,5,6,7,8,9,10}→{1,3,5,7,9}→{1,7}
// Sajjad Ahmed Shaaz, 002410501093

import java.util.Scanner;

public class Series {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;

        System.out.println("Enter n: ");
        n=sc.nextInt();

        int arr[]=new int[n];

        for (int i=0;i<n;i++) {
            arr[i]=i+1;
        }

        for (int i=0;i<n;i++) {
            System.out.print(arr[i]+" -> ");
        }
        System.out.println();

        int skipCount=2;
        while (skipCount<=n) {
            int size=0;
            for (int i=0; i<n; i+=skipCount)
                size++;

            int newArr[]=new int[size];
            for (int i=0, j=0; i<size; i++, j+=skipCount) {
                newArr[i]=arr[j];
            }

            System.out.print("Array after skipping "+skipCount+" elements: ");
            for (int i=0; i<size; i++) {
                System.out.print(newArr[i]+" -> ");
            }
            System.out.println();
            arr=newArr;
            n=size;
            skipCount++;
        }
        sc.close();
    }    
}
