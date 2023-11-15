package com.test.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.directory.DirContext;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sun.org.apache.bcel.internal.generic.IREM;
import com.test.Base.TestBase;
import com.test.Pages.AddBasketPage;
import com.test.Pages.CheckOuPage;
import com.test.Pages.Homepage;
import com.test.Pages.Shoppage;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record.ForDefinedMethod.WithAnnotationDefaultValue;
import sun.nio.cs.ext.DoubleByteEncoder;

public class HomePageTestCase extends TestBase {
	Homepage homepage;
	Shoppage shoppage;
	AddBasketPage basketPage;
	CheckOuPage checkoutpage;

	public HomePageTestCase() {
		super();
	}

	@Parameters("browser")
	@BeforeClass
	void beforeStart(@Optional("chrome") String browser) throws IOException {
//		 String browser="Chrome";
		initial(browser);
		homepage = PageFactory.initElements(driver, Homepage.class);
		shoppage = PageFactory.initElements(driver, Shoppage.class);
		basketPage = PageFactory.initElements(driver, AddBasketPage.class);
		checkoutpage = PageFactory.initElements(driver, CheckOuPage.class);
	}

	@AfterClass
	void afterFinish() {
	 quitApp();
	}

	// @Test(retryAnalyzer = com.test.Listeners.RetryAnalyzer.class)
	@Test()
	void TC_1() throws InterruptedException {
		homepage.clickonShopmenue();
		logger.info("shoppage is clicked");
		shoppage.clickHomepage();
		  Thread.sleep(1000);
    System.out.println(driver.getCurrentUrl());   
      
		int slidersCnt = homepage.getSliders();
		  
		assertEquals(slidersCnt, 3);

	}

	@Test
	void TC_2() {

		int arrivalsCnt = homepage.getArrivals();
//	 WebElement element1=driver.findElement(By.xpath("//*[@id=\"menu-icon-close\"]"));

//	 JavascriptExecutor jse = (JavascriptExecutor) driver;
//	 jse.executeScript("arguments[0].click();", element1);
		// element.click();
		assertEquals(arrivalsCnt, 3);
		homepage.clickArrivals();
		logger.info("element clicked");

	}

	@Test
	void TC_3() {
		basketPage.addItems();
		logger.info("item added t basket");
		String message = basketPage.getMessage();
		System.out.println(message);
		assertEquals(message, message);
	}

	@Test
	void TC_4() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		basketPage.clickReviewTab();
		logger.info("ReviewTab clicked");

		String messageR = basketPage.getReviewMessage();
		System.out.println(messageR);
		basketPage.clickdiscriptionTab();
		logger.info("DiscriptionTab clicked");
		String meesageD = basketPage.getMessageD();
		System.out.println(meesageD);
		assertTrue(!meesageD.isEmpty());
	}

	@Test()
	void TC_5() {
		int totalItems = basketPage.getTotalItemsICart();
		System.out.println(totalItems);
		assertEquals(totalItems, 1);
		float totalPrice = basketPage.getTotalPriceShowing();
		System.out.println("total price" + totalPrice);
		assertEquals(totalPrice, totalPrice);
		String symbolString = basketPage.getSymbol();
		assertTrue(symbolString.contains("₹"));

	}

	@Test()
	void TC_6() {
		String availabeStock = basketPage.getstockCount();
		System.out.println(availabeStock);
		assertEquals(availabeStock, availabeStock);
		basketPage.sendNumber();
		basketPage.addItems();

		logger.info("Basket clicked again");
//     WebDriverWait wait=new WebDriverWait(driver, 20);
// wait.until(ExpectedConditions.alertIsPresent());
//    
//	  Alert  alert=driver.switchTo().alert();
//	  String textString=alert.getText();
//	  System.out.println(textString);
		System.out.println(!availabeStock.isEmpty());

	}

	@Test
	void TC_7() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a"));
		new WebDriverWait(driver, 10l).until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);

		// assert if the new page is opened
		boolean res = checkoutpage.cuponButton();
		if (res == true) {
			Assert.assertTrue(true);
			System.out.println("Check out window is visialbe");
		} else {
			Assert.assertTrue(false);
			System.out.println("false");
		}
	}

	@Test
	void TC_8() {

		String numString = checkoutpage.getPriceofBOOK();
		System.out.println(numString);
		double num = Double.parseDouble(numString);
		System.out.println("number is " + num);

//		String meString=checkoutpage.couponMessage();
//		System.out.println(meString);

		if (num <= 449) {
			checkoutpage.getCupon();
			String meString = checkoutpage.couponMessage();
			System.out.println(meString);
		}
		if (num >= 450) {
			checkoutpage.getCupon();
			String string = checkoutpage.getMessage2();
			System.out.println(string);
		}

	}

	@Test
	void TC_9() {
		// checkoutpage.printTable();
		ArrayList<String> tableRowName = checkoutpage.getTables();
		System.out.println(tableRowName);
		List<Double> newList = new ArrayList<>();
		for (String s : tableRowName) {
			newList.add(Double.parseDouble(s));
		}

		System.out.println(newList);
//	    assert.assertEquals(newList.containsAll(newList) null);
		double max = newList.get(0);
		double min = newList.get(0);
		int n = newList.size();
		for (int i = 1; i < n; i++) {
			if (newList.get(i) < min) {
				min = newList.get(i);
			}
		}
		for (int i = 1; i < n; i++) {
			if (newList.get(i) > max) {
				max = newList.get(i);
			}
		}
		System.out.println("With tax " + max);

		System.out.println("tax amount is  " + min);

		System.out.println("subtotal before tax  " + (max - min));

	}
 

 }
  

  


