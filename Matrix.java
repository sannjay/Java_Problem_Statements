/* Problem Statement
Praveen went crazy yesterday and created an arbitrary matrix consisting of 0, 1 or 2. There was no rule observed in forming this matrix. But then he made up some rules himself.

If there are adjacent 1's, they are said to be connected. Similarly, if there are adjacent 2's, they are said to be connected. Here adjacent means all the surrounding positions along with the diagonal positions.

Now given a matrix of 0, 1 or 2, do your computation according to the following rules:

If there is a path from any position in top row to any position in bottom row consisting only of 1, then print 1.
If there is a path from any position in first column to any position in last column consisting only of 2, then print 2.
If both Rule 1 & Rule 2 are true, print .
If none of Rule 1, Rule 2 or Rule 3 satisfies, print 0.
Input format

First line of input contains a positive integer N, the size of matrix. Then N line follows, each containing N integers which are either 0, 1 or 2.

Output format

Print a single line containing the output according to the rule mentioned. Clearly, the output can only be 0, 1, 2 or .

Input constraint

Example
4
0 0 0 0
2 0 1 0
0 2 1 2
0 1 2 0

Here the output is 2, as there is a connected path of 2 from first column to last column.

SAMPLE INPUT 
3
0 0 1
0 1 2
2 2 1
SAMPLE OUTPUT 
AMBIGUOUS
Explanation
In the sample input, there is a connected path of 1 from first row to last row, and there is a connected path of 2 from first column to last column as well. So, the result is .
*/

/* Solution */

import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class Matrix {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                 // Reading input from STDIN
    //    System.out.println(n);    // Writing output to STDOUT
    int[][] mat = new int[n][n];

 for(int i=0;i<n;i++)
 {
     for(int j=0;j<n;j++)
     {
         mat[i][j] = s.nextInt();
        // System.out.print(mat[i][j] + " ");
     }
 }s.close();
 
  int temp=n;
 boolean h=false, flag =false,con1=false,con2=false;
 // connecting rows with 1
  for(int i=0;i<n;i++)
 {
     for(int j=0;j<n;j++)
     {
         if(i==0 && mat[i][j] ==1)
         {
         temp = j;
         //flag = true;
         
         //System.out.print("j="+j );
         break;
         }
         else if(j==n-1 && temp==n)
         {
        flag=true;
        //System.out.print("true j="+j );
         break;
         }
         if(i>0 && mat[i][j] ==1)
         {
             h=check(temp,j,n);
             if(h){
          //  System.out.print("j="+j );
             temp=j;
             break;
             }
         }else if(j==n-1)
             {temp=n;
             flag =true;
             break;
             }
     }
     if(flag && temp==n)
     {
     con1=false;
     break;
     }else if(i==n-1)
     con1=true;//System.out.println("print 1");
  }
  
 temp=n;
 h=false; flag =false;
 // connecting rows with 1
  for(int i=0;i<n;i++)
 {
     for(int j=0;j<n;j++)
     {
         if(i==0 && mat[j][i] ==2)
         {
         temp = j;
        // flag = true;
        // System.out.print("j="+j );
        break;
         }
         else if(j==n-1 && temp==n)
         {
        flag=true;
         break;
         }
         if(i>0 && mat[j][i] ==2)
         {
             h=check(temp,j,n);
             if(h){
          //  System.out.print("j="+j );
             temp=j;
             break;
             }
         }else if(j==n-1)
             {temp=n;
             break;
             }
     }
     if(flag && temp==n)
     {
     break;
     }else if(i==n-1)
     con2=true;//System.out.println("print 2");
  }
      // Write your code here
      if(con1&& con2)
      System.out.println("AMBIGUOUS");
      else if(con1)System.out.println("print 1");
      else if(con2)System.out.println("print 2");
      else System.out.println("print 0");
      
}
    static boolean check(int a, int b, int s)
    {
        boolean d=false;
        while(s!=0)
        {
            if(a==b||(a-1)==b||(a+1)==b)
            {
            d=true;
            break;
            }
            s--;
        }
        return d;
    }
}
