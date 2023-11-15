package com.test.Pages;

import java.time.Duration;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.TestBase;

import io.netty.util.Timeout;
import sun.tools.jar.resources.jar;



public class CheckOuPage extends TestBase {
	
	@FindBy(xpath = "//*[@name=\"apply_coupon\"]")
	WebElement applyCuponButton;
	
	public boolean cuponButton() {
		if(applyCuponButton.isDisplayed()) {
			System.out.println("new page visiable");
		}else {
			System.out.println("New page not visiable");
		}
		return true;
	}
	@FindBy(xpath = "//*[@name=\"coupon_code\"]")
	    WebElement cuoponCode;
 public void getCupon() {
	 cuoponCode.sendKeys("krishnasakinala");
	  applyCuponButton.click();

 }
 @FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/ul/li")
 WebElement messagElement;
 public String couponMessage(	) {
	 String message=messagElement.getText();
	 System.out.println(message);
	return message;
	 
 }
 @FindBy(xpath = "//*[@class=\"product-price\"]/span")
    WebElement priceofBook;
 public String getPriceofBOOK() {
	 String  numString=priceofBook.getText().substring(1);
	 System.out.println(numString);
	return numString;
	 
 }
@FindBy(xpath = "//*[contains(text(),\"Coupon code applied successfully\")] ")
 WebElement cuponMessage2;
	   public String getMessage2() {
		   String string=cuponMessage2.getText();
		 
		return string;
	   }
	   @FindBy(xpath = "// table[@class=\"shop_table shop_table_responsive\"]")
	    WebElement table;
//	   List<WebElement > rowsElements=table.findElements(By.tagName("tr"));
//		List<WebElement> columList=null;
//		
	   public void printTable() {
		   List<WebElement > rowsElements=table.findElements(By.tagName("tr"));
	List<WebElement> columList=null;
	
    for(WebElement row:rowsElements) {
       
		
			columList=row.findElements(By.xpath("td"));
		for(WebElement colum:columList) {
		 System.out.println( row.getText().replace('?',  '='));
    }
    
	
	
		
			
		}
	
			
	   }
	   @FindBy(xpath = "//table[@class=\"shop_table shop_table_responsive\"]//td")
	    List<WebElement> tablesElements;
	 
	   public ArrayList<String> getTables(){
		   ArrayList<String > nameofRow=new ArrayList<String>();
		   for(WebElement row:tablesElements) {
			   nameofRow.add(row.getText().substring(1));
			  
			
		   }
		    System.out.println(nameofRow);
		      return nameofRow;
	   }
	   @FindBy(xpath = "//html/body//a")
	          WebElement checkOUTElement;
	   
   public void clickcheckOut() {
	  
	 
	   JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
	   jsExecutor.executeScript("arguments[0].click();",checkOUTElement);
      //    checkOUTElement.click();
   }
   @FindBy(xpath = "//*[@id=\"customer_details\"]/div[1]/div/h3")
   WebElement billingPageMessag;
   
   public  boolean validateBillingPage() {
	   return billingPageMessag.isDisplayed();
	 
	
	 
   }
			}
	  
 
	  

 

