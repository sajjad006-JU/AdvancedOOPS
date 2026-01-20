// 5. Write a program where class contains void show(int) to display the argument passed. Call the 
// function once with short as actual parameter and again double as actual parameter. Add another 
// function as void show(double) . Repeat the calls. Observe the outcomes in each case. 
// Sajjad Ahmed Shaaz, 002410501093

public class Argument {

    static void show(int a) {
        System.out.println("in show(int)");
        System.out.println(a);
    }

    static void show(double a) {
        System.out.println("in show(double)");
        System.out.println(a);
    }

    public static void main(String[] args) {
        short s1=34;
        show(s1);
        
        double d1=23.21;
        // show(d1); shows error as we cannot pass in double to type int without explicit type casting
        show(d1);
    }    
}
