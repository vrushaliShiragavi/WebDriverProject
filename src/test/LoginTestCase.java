package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
		// Step 1 : Launch crome browser and open website
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		// Step 2 : Maximise the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);	

		//WebElement title = driver.findElement(By.tagName("title"));
		//System.out.println("title : " + title.getText().getBytes().toString());		

		// Step 3 : Click on Login Link
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		String location = LoginLink.getAttribute("href");
		System.out.println(driver.getTitle());
		System.out.println(location);
		LoginLink.click();
		
		// Step 4 : Enter user name
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("abc@xyz.com");
		
		// Step 5 : Enter password
		//WebElement password = driver.findElement(By.name("user_pwd"));
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Abc@12345");
		//WebElement showPassword = driver.findElement(By.id("password-icon"));
		//showPassword.click();
		
		//Step 6 : Click on login button
		WebElement login = driver.findElement(By.name("btn_login"));
		login.click();
		
		// step-7 : Validate the login was unsuccessful and error message is as expected
		WebElement error = driver.findElement(By.className("error_msg"));
		/*if(error != null) {
			System.out.println("Login Error occured ! ");
			System.out.println("Error Msg : " + error.getText());
		}
		else {
			System.out.println("Login Successfull !");
		}*/

		String errorMsg = error.getText();
		String expErrorMsg = "The email or password you have entered is invalid.";
		
		if(error.isDisplayed() && errorMsg.equals(expErrorMsg)) {
			
			System.out.println("TC Passed");
		}else {
			
			System.out.println("TC Failed");
		}
		//Step 8 : Check Remember Me
		WebElement RemMe = driver.findElement(By.className("rememberMe"));
		RemMe.click();
		//Step 8.1 : find all elements the <a>
		List<WebElement> allLinks = driver.findElements(By.tagName("a")); 
		System.out.println("Total nuber of links : " + allLinks.size());
		//Step 8.1.1 : find all href tags inside <a>
		for (WebElement x:allLinks) {
			String i = x.getAttribute("href");
			System.out.println(i);
		}
		//Step 9 : close the browser
		driver.close();

	}

}
