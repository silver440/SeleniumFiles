package com.test.Listeners;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sun.xml.internal.bind.CycleRecoverable.Context;
import com.test.Base.TestBase;

public class TestListener extends TestBase implements ITestListener {
	@Override
	public
	void onTestFailure(ITestResult result	) {
		System.out.println("****************Error******"+result.getName()+"test has failed****");
		String methodNameString=result.getName().toString().trim();
//		ITestContext context=result.getTestContext();
		
		try {
			takeScreenshot(methodNameString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
