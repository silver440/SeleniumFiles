package com.test.Pages;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.TestBase;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes.FaasTriggerValues;

public class AddBasketPage  extends TestBase{
	@FindBy(xpath = "//*[@type=\"submit\"]")
	   WebElement addToBasket;
	   
	   public void addItems() {
		   addToBasket.click();
		  
		  
	   }
 @FindBy(xpath = "//*[@id=\"content\"]/div[1]")
		    WebElement messageLink;
  
 public String getMessage() {
	 String message=messageLink.getText();
	System.out.println(message);
	return message;
	
	 }
 @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div[3]/ul/li[2]/a")
     WebElement reviewTabs;
 @FindBy(xpath = "//*[@id=\"comments\"]/p")
      WebElement reviewText;
 public void clickReviewTab() {
	  reviewTabs.click();
	  }
 public String getReviewMessage() {
	 String messageString=reviewText.getText();
	return messageString;
	 
 }
 @FindBy(xpath = "//*[@class=\"woocommerce-tabs wc-tabs-wrapper\"]/ul/li[1]")
      WebElement discriptionTab;
 public  void clickdiscriptionTab() {
	  discriptionTab.click();
	  }
 @FindBy(xpath = "//*[@id=\"tab-description\"]/h2")
     WebElement discriptionMessage ;
  public String getMessageD() {
	  String messageD=discriptionMessage.getText();
	return messageD;
  }
  @FindBy(xpath = "//*[@id=\"wpmenucartli\"]/a/span[1]")
     WebElement totalItemsInBasket;
   public int getTotalItemsICart() {
	  
	  String string1=totalItemsInBasket.getText().substring(0, 1);
	  System.out.println(string1);
int itemCnt=Integer.parseInt(string1);
	return itemCnt;
	  
  }
  @FindBy (xpath="//*[@id=\"wpmenucartli\"]/a/span[2]")
   WebElement priceShowing;
  public float getTotalPriceShowing() {
	  String stP=priceShowing.getText().substring(1);
	  float totalp =(float) Double.parseDouble(stP);
			  System.out.println(totalp);
	return totalp;
	  
  }
  public String getSymbol(	) {
	  String symbol=priceShowing.getText().substring(0,1);
	return symbol;
  }
  @FindBy(xpath = "//*[@class=\"stock in-stock\"]")
 WebElement stockCnt ;
 
  public   String getstockCount() {
	  String strM=stockCnt.getText();
	return strM;
  }
  @FindBy(xpath = "//*[@class=\"quantity\"]/input")
  WebElement inputNumber;
  public String sendNumber() {
	 
	  String strM=stockCnt.getText();
	  String string=strM.replace("in stock", "");
	  
	  string =string.trim();
	  System.out.println(string);
	    String num=String.valueOf(Integer.parseInt(string)+1);
	    inputNumber.sendKeys(num);
	    System.out.println("Keys send");
  return num;
  }
  @FindBy(xpath = "//*[@id=\"content\"]/div[1]/a")
	  WebElement viewBasketElement ;
	 public void clickviewBasket() {
	  viewBasketElement.click();
  }
	 //===================CheckOutPage=================


}
