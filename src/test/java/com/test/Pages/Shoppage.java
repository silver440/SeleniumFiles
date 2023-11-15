package com.test.Pages;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SortingFocusTraversalPolicy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.test.Base.TestBase;

public class Shoppage extends TestBase{
	@FindBy(xpath = "//*[text()=\"Home\"]")
	 WebElement homePage;
	
	public void clickHomepage() {
		homePage.click();
	}
 @FindBy(xpath = "//div[@class=\"price_slider_wrapper\"]/div/span")
 List<WebElement>slidersElements;
   
 public void moveSliders( int min, int max) {
	 WebElement element1=  slidersElements.get(0);
	 WebElement element2=slidersElements.get(1);
//			 System.out.println(element1.getLocation());//(22 284)
//			 System.out.println(element2.getLocation());//(211 284)
//			
	   Actions actions =new Actions(driver);
	   actions.dragAndDropBy(element1, min, 0).build().perform();
	   System.out.println(element1.getLocation());
	   actions.dragAndDropBy(element2, max, 0).build().perform();
	   
}
   @FindBy(xpath = "//*[@class=\"price_label\"]/span")
   List<WebElement> spanPrice;
   
   public ArrayList<String>spanValueBefor(){
    	ArrayList<String>spanValue=new ArrayList<String>();	
    	for(WebElement elem:spanPrice) {
    	spanValue.add(elem.getText().substring(1));
    	}
    	
    	 
		return spanValue;
    	
    }
   @FindBy(xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[2]/button")
        WebElement filterButton;
   public void clickFilterButton() {
	   filterButton.click();
   }
   @FindBy(xpath = "//*[@id=\"woocommerce_product_categories-2\"]/ul/li")
   public List<WebElement> productList;
public Object clickonProductsList;
   
   public void clickonProductsList( int i) {
	   System.out.println(productList.get(i).getText());
	   productList.get(i).findElement(By.xpath("./a")).click();
	   
   }
   @FindBy(xpath = "//ul[@class=\"product-categories\"]/li")
   public List<WebElement>screenList;
   
   public boolean  isScreenLnk(String type) {
	   boolean flag=true;
	   for(WebElement el:screenList) {
		   if(!el.findElement(By.xpath("./a")).getText().contains(type)){
			   flag=false;
			   break;
		   }
				
	   }
	   return flag;
   }
   
	   
   @FindBy(xpath = "//*[@id=\"content\"]/form/select")
   public WebElement defaultSr;
 
   public void sortByDropName(String sortype ) {
	   Select dropElm=new Select(defaultSr);
	   dropElm.selectByVisibleText(sortype);
	   
	   
   }
   @FindBy(xpath = "//*[@id=\"content\"]/ul/li")
   public List<WebElement> afterDropdownMenuElements;
   
   public int getSortedDropDown() {
	   return afterDropdownMenuElements.size();
   }
   @FindBy(xpath = "//*[@id=\"content\"]//h3//following::span[1]//span")
   public List<WebElement>listofBookswithPrice;
   
    public ArrayList<String>priceafterDropdown(){
    	ArrayList<String>arrayList=new ArrayList<String>();
    	for( WebElement element:listofBookswithPrice) {
    	arrayList.add(element.getText().substring(1));
    
    	}
    	
      System.out.println(arrayList);
		return arrayList;
    	
    }
   
   
   
    public String getSortedByIndex( int i) {
    	Select select=new Select(defaultSr);
    	String string=		 select.getOptions().get(i).getText();
    	      select.getOptions().get(i).click();

				return string;
    }
   @FindBy(xpath = "//*[@id=\"woocommerce_product_categories-2\"]/ul/li/a")
   List<WebElement>booksElements;
    public void addbooks( String nameofBook) {
    	ArrayList<String> book=new ArrayList<String>() ;
    	 for(WebElement elem:booksElements) {
    		 if(elem.getText().contains(nameofBook)) {
    			 elem.click();
    		 }
    	 }
    	
    	
    }
   @FindBy(xpath = "//*[@id=\"content\"]/ul/li[1]/a[1]/h3")
     List<WebElement> booksRelated;
   
   public void clickRelatedbook( String booksOnScr) {
	   ArrayList<String> booksontheScreen=new ArrayList<String>();
	   for(WebElement elem:booksRelated) {
		   if(elem.getText().contains(booksOnScr)) {
			   elem.click();
		   }
	  
		 
	   }
}
   
}
