/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class prefixsum
{
	public static void main (String[] args) 
	{
		 int a[]= {10,5,3,7,1,8,20,30};
		 int n = a.length;
		 
		 int prefix[]= new int[n];
		 prefix[0]= a[0];
		 for( int i=1;i<n;i++)
		 {
		 	prefix[i]= prefix[i-1]+a[i];
		 }
		 for( int i=0;i<n;i++)
			System.out.print( prefix[i]+ " ");
	}
}