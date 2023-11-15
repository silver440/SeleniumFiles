package InterviewPractice;


import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.chrome.AddHasCasting;



public class SwapNumbers {
	public static void main(String[]args) {
   swapNumbers();
		swapStrings();
		reverseString();
	    	   }
	     public static  void swapNumbers() {
	    	 int num=3; int numb=4;
	    	 System.out.println("before swap"+num+"."+numb);
	    	 num=num+numb;
	    	 numb=num-numb;
	    	 num=num-numb;
	    	 System.out.println("After the swipe"+num+"and "+numb);
	    	     }
	     public static void  swapStrings() {
	    	String  st1="Maya";
	    	 String st2="Laylehan";
	    	 System.out.println("Before  :"+st1+":"+st2);
	    	 st1=st1+st2;
	    	st2=st1.substring(0,st1.length()-st2.length());
	   
	        st1=st1.substring(st2.length());
	    	System.out.println("after the swipe  "+st1+":"+st2);
	    	
	    	
	     }
	     public static void reverseString() {
	    	 String string="Mother";
	    	 String st1="";
	    	 for(int i=string.length()-1; i>=0; i--) {
	    		 st1=st1+ string.charAt(i);
	    	 }
	    	 System.out.println(st1);
	     }

}	
			 
		

    	


