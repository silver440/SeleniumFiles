package InterviewPractice.string;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Arrays;
import java.util.List;

import org.checkerframework.checker.units.qual.C;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class DuplicateCharacters {

	public static void main(String[] args) {
     String string="mayalandulmer";
// this method is taking the string without any duplicates
	 String withoutduplicatString=withoutDuplicate(string);
//	 System.out.println(withoutduplicatString);
//	getDuplicate(string);
//	String string2=reversewithout(string);
//	System.out.println("Reversed string without :"+string2);
	//	reversewithouut2();
	//  findDuplicatesArray();
		firstNonrepeatedChar();
	}
   static  String withoutDuplicate(String st) {
    	char [] c=st.toCharArray();
    	String tr="";
    	for( char value:c) {
    		if(tr.indexOf(value)==-1) {
    			tr+=value;
    
    		}
    	
    	}
    		
		return tr;
    	
    }
    static void getDuplicate(String st) {
    	int y;
    	int count = 0;
    	String st1="";
    	char c[]=st.toCharArray();
    	for(int i=0; i<c.length; i++) {
    		for( y=i+1; y<c.length; y++) {
    			 if(c[i]==c[y]) {
    				 count++;
    	st1=st1+st.charAt(i);
    	
    		
    			 }
    	
    		}
    	
    	
    	
    }
System.out.println("number of duplicates are"+count);
System.out.println("The duplicates are: "+st1);
    }
    static String reversewithout(String st) {
    	String oneString="";
    	for(int i=st.length()-1;i>=0;i--) {
    		oneString=oneString+st.charAt(i);
    		//System.out.println(oneString);
    	}
		return oneString;
    	
    }
    static void reversewithouut2() {
    	String[] wordStrings= {"maya","laya", "gula"};
    	for(int i=wordStrings.length-1; i>=0; i--) {
    		System.out.print(wordStrings[i]+",");
    		
    	}
    	
    }
    static void findDuplicatesArray() {
    	int y;
    	String [] arr= {"mala","nala","mala","ala","miya", "ala"};
    	System.out.println("original array"+Arrays.toString(arr));
    	
    		for(int i=0; i<arr.length-1;i++) {
    		for(y=i+1; y<arr.length; y++) {
    			if(arr[i].equals(arr[y])&&(i!=y)) {
    			
    				System.out.println(arr[y]);
    			}
    		}
    	}
    }
   static void firstNonrepeatedChar() {
	   String string="Teeter";
	   for(char i:string.toCharArray()) {
		   if(string.indexOf(i)==string.lastIndexOf(i)) {
			   System.out.println("non repeated charactr is: "+i);
			   break;
		   }
	   }
	   
		   }
	  
  
}



