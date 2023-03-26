package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("abc@gmail.com");
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("abc@gmail.com");
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		WebElement validate = driver.findElement(By.className("_9ay7"));
		if(validate != null) {
			System.out.println("Error massage is : " + validate.getText());
		}
		userName = driver.findElement(By.id("email"));
		userName.clear();
		userName.sendKeys("abcgmail.com");
		password = driver.findElement(By.id("pass"));
		password.clear();
		password.sendKeys("abcgmail.com");
		loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		validate = driver.findElement(By.className("_9ay7"));
		if(validate != null) {
			System.out.println("Error massage is : " + validate.getText());
		}
	}

}
