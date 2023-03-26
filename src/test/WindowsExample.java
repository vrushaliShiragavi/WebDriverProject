package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement newTab = driver.findElement(By.id("tabButton"));
		String PaerentWin = driver.getWindowHandle();
		System.out.println("Parent win is " + PaerentWin);
		newTab.click();
		Set<String> AllWin = driver.getWindowHandles();
		String childWin = "";
		for (String win : AllWin) {
			System.out.println("The win ID is " + win);

			if (!win.equals(PaerentWin)) {
				childWin = win;
			}
		}
		System.out.println("Child win is " + childWin);
		driver.switchTo().window(childWin);
		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in child win is " + childHeader.getText());
		driver.close();
		
		driver.switchTo().window(PaerentWin);
		WebElement secondTab = driver.findElement(By.id("windowButton"));
		secondTab.click();		

		AllWin = driver.getWindowHandles();
		childWin = "";
		for (String win : AllWin) {
			System.out.println("The win ID is " + win);

			if (!win.equals(PaerentWin)) {
				childWin = win;
			}
		}
		System.out.println("Child win is " + childWin);
		driver.switchTo().window(childWin);
		childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in child win is " + childHeader.getText());
		driver.quit();
		//driver.close will close the browser and driver.quit will close all the browser opend by selenium
		

	}

}
