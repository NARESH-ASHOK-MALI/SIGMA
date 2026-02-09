/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class prefixMax
{
	public static void main (String[] args) throws java.lang.Exception
	{
		  int a[]={5,2,3,10,1};
		  int n= a.length;
		  
		  int pMax[]= new int[n];
		  
		  pMax[0]=a[0];
		  
		  for( int i=1;i<n;i++)
		  {
		  	pMax[i]= Math.max( pMax[i-1],a[i]);
		  }
		  
		  for( int i=0;i<n;i++)
		  {
		  	System.out.print( pMax[i]+" ");
		  }
	}
}

