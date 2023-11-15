package InterviewPractice;

import java.security.PublicKey;
import java.util.Arrays;

import org.checkerframework.checker.units.qual.s;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ReverseString {

	public static void main(String[] args) {
//	reverseStringwithout();
//	reverseGivenNumber();
//		reverseWithbuffer();
//		reverseStringwithbuffer();
//		reverseArrayNumbers();
//		reverseGivenWordsinArray();
	//	countNumberofCharacters();
	}
    public static void reverseStringwithout() {
     String st1="Maya is good women";
     String stspace="";
     for(int i=st1.length()-1; i>=0; i--) {
    	 stspace=stspace+st1.charAt(i);
    	
    	 
     }
      System.out.println(stspace);
    }
    public static void reverseGivenNumber() {
    	int number=1234;  
          int remainder; int sum=0;
    while(number!=0) {
    	remainder=number%10;
    	sum=sum*10+remainder;
    	 number=number/10;
    	
    }
    System.out.println(sum);
    }
    public static void reverseWithbuffer() {
    	int  numb=1234;
    	int numb2=0;
    	StringBuffer sBuffer=new StringBuffer();
                sBuffer.append(numb);
                String string=sBuffer.reverse().toString();
                System.out.println(string);
                numb2=Integer.parseInt(string);
                System.out.println(numb2);
                
    	
    }
    public static void reverseStringwithbuffer() {
    	String string="Why suffering";
    	StringBuffer sBuffer=new StringBuffer(string);
    	String stnewString=sBuffer.reverse().toString();
    	System.out.println(stnewString);
    }
    public static void reverseArrayNumbers() {
    	int [] num= {12,13,14,15,16};
    	System.out.println(Arrays.toString(num));
    	for(int i=num.length-1; i>=0; i--) {
    	System.out.print(num[i]+",");
    	}
    	System.out.println();
    }
    public static void reverseGivenWordsinArray() {
    	String [] wordStrings= {"mother", "Layla","Huma","loma"};
    	System.out.println(Arrays.toString(wordStrings));
    	for(int i=wordStrings.length-1; i>=0; i--) {
    		System.out.print(wordStrings[i]+",");
    	}
    	
    }
    public static void countNumberofspace() {
    	String string="I miss my mother";
    	int count=0;char c;
    	  int totalChararcters = 0;
    	 for(int i=0; i<string.length(); i++) {
    		if(string.charAt(i)==' ') {
    			count++;
    		 }
    }System.out.println(count);
	 
	}
}
