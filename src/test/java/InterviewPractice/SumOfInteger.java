package InterviewPractice;

import java.security.PublicKey;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class SumOfInteger {

	public static void main(String[] args) {
		sumLop();
		sumofGivenEnteger();
		primeNumber();
	}
		
	

 public static void sumLop() {
	 int sum=0;
	 for(int i=0; i<=4; i++) {
		 sum+=i;
		
 }
       System.out.println(sum);
	
 }	
  public static void sumofGivenEnteger() {
	  int number=453; int remainder=0; int sum=0;
	  while(number!=0) {
		remainder=number%10;
		sum+=remainder;
		number=number/10;
	  }
	  System.out.println(sum);
  }
  public static void primeNumber() {
	  int i;
	 int numb=11;
	 for( i=2; i<=numb/2; i++) {
		 if(numb%i==0) {
			 break;
		 }
			 
	 }
	 if(i>numb/2) {
		 System.out.println("it is prime");
		 
	 }else {
		 System.out.println("it is not prime");
	 }
  }
 
}

