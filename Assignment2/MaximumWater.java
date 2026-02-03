import java.util.*;
public class MaximumWater {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n;
        System.out.println("Enter the value of n : ");

        n=sc.nextInt();
        int heights[]=new int[n];

        System.out.println("Enter the heights : ");
        for (int i = 0; i < heights.length; i++) {
            heights[i]=sc.nextInt();            
        }

        double y_dash[]=new double[n];

        for (int i = 0; i < y_dash.length; i++) {
            y_dash[i]=(double)heights[i]/Math.sin(Math.toRadians(60));
        }

        int i=0, j=n-1, maxi=0, maxj=n-1;
        int maxWater=0;

        while (i<j) {
            int water=(j-i)*Math.min(heights[i], heights[j]);
            // float water =(float) (1.0/2.0*(j-i)*Math.min(heights[j], heights[i]));
            
            if (water>maxWater) {
                maxWater=water;
                maxi=i;
                maxj=j;
            }

            if (heights[i]<heights[j]) 
                i++;
            else
                j--;
        }

        System.out.println("Maximum Water: "+maxWater + " at i="+maxi+", j="+maxj);
    }
}
