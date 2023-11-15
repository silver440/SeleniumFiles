package com.test.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.TestBase;

public class Homepage extends TestBase {
	@FindBy(xpath = "//*[@id=\"main-nav\"]/li[1]")
	   WebElement shopMenue;
	
	@FindBy(xpath = "//*[@class=\"woocommerce-LoopProduct-link\"]")
	List<WebElement> arrivals;
	
	@FindBy(xpath = "//*[@data-slide-duration=\"0\"]")
	List<WebElement>sliders;
	
	@FindBy(xpath = "//span[@class='price']//preceding::h3")
	 List<WebElement> books;

   
	public  void clickonShopmenue() {
	   shopMenue.click();
	   }
	public int getSliders() {
		int sliderCnt=sliders.size();
		
		return sliderCnt;
		
	}
	public int getArrivals() {
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfAllElements(arrivals));
		int arrivalsCnt=arrivals.size();
		return arrivalsCnt;
	}
   public void  clickArrivals() {
	arrivals.get(1).click();
//	public void clickArrivals() {
//		for(WebElement element:books) {
//			if(element.getText().equalsIgnoreCase("Selenium Ruby")) {
//				element.click();
//			}
//		}
   }
   
 }

