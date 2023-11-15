package com.test.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import com.test.Base.TestBase;
import com.test.Pages.AddBasketPage;
import com.test.Pages.Homepage;
import com.test.Pages.Shoppage;






public class ShoppingTestCs  extends TestBase{
	Homepage homepage;
	Shoppage shoppage;
	AddBasketPage basketPage;
	
  public ShoppingTestCs() {
	  super();
  }
	  @Parameters("browser")
	  @BeforeClass
	  void beforestart(@Optional("Chrome") String  browser) throws IOException {
		  initial(browser);
	  homepage=PageFactory.initElements(driver, Homepage.class);
	  shoppage=PageFactory.initElements(driver, Shoppage.class);
	  basketPage=PageFactory.initElements(driver, AddBasketPage.class);
	  }
	  @AfterClass
	  void afterDone() {
	//  quitApp();
	  
  }
	  @Test
	  void TC_1() {
		  homepage.clickonShopmenue();
		   ArrayList<String > priceRange=shoppage.spanValueBefor();
		  int min=Integer.parseInt(priceRange.get(0));
		  int max=Integer.parseInt(priceRange.get(1));
		  System.out.println("Price range before="+min+"maxiumprice="+max);
		  assertEquals(min, 150);
		  assertEquals(max, 500);
		
		  shoppage.moveSliders( 5, -33);
		  ArrayList<String > priceRangeafter=shoppage.spanValueBefor();
		  int minafter=Integer.parseInt(priceRangeafter.get(0));
		  int maxafter=Integer.parseInt(priceRangeafter.get(1));
		  System.out.println("Price range after ="+minafter+","+"maxiumprice= "+maxafter);
		  shoppage.clickFilterButton();
		  
	  }
	  @Test
	  void TC_2() {
		  //get product catogories index 1 and text to compare if its match.
	      int IntegerIndex=1;
	      shoppage.clickonProductsList(IntegerIndex);
	      String linkText =shoppage.productList.get(IntegerIndex).findElement(By.xpath("./a")).getText();
	      String linkCnString =shoppage.productList.get(IntegerIndex).findElement(By.xpath("./span")).getText();
		  linkCnString=linkCnString.replace("(","");
		  linkCnString=linkCnString.replace(")", "");
		  int m=Integer.parseInt(linkCnString);
	       System.out.println(linkText);
	      System.out.println(m);
		  equals(shoppage.isScreenLnk(linkText)&&shoppage.screenList.size()==m);
	  }
	  @Test
	   void TC_3() {
		  shoppage.sortByDropName("Sort by price: low to high");
	 int number=	shoppage.getSortedDropDown();
			 assertEquals(number,3);
	 	 ArrayList<String > priceLowtoHigh=	 shoppage.priceafterDropdown();
		 System.out.println(priceLowtoHigh);
		 shoppage.sortByDropName("Sort by price: high to low");
		 ArrayList<String > priceLowtoHigh2=	 shoppage.priceafterDropdown();
		 System.out.println(priceLowtoHigh2);
		
	
      }
	  @Test
	  void TC_4() {	
		  String textString= shoppage.getSortedByIndex(3);
		 System.out.println(textString);
	     assertEquals(textString, "Sort by newness");
	  }
         @Test
         void TC_5() {
        	 shoppage.addbooks("JavaScript");
        	 driver.navigate().refresh();
    //    	shoppage.clickRelatedbook("HTML5 Forms");
        
         }
	  }

