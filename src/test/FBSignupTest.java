package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignupTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement signUpBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signUpBtn.click();
		// WebElement firstname =
		// driver.findElement(By.xpath("//input[@aria-label='First name']"));
		//for css selector ise By.cssselector and then path for css selector
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement mobileNumber = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		firstname.sendKeys("abc");
		lastName.sendKeys("abc");
		mobileNumber.sendKeys("9999999999");
		password.sendKeys("abc");
		//print dfault slected date
		WebElement selectedDay = driver.findElement(By.xpath("//select[@title='Day']/option[@selected='1']"));
		System.out.println("The default day is " + selectedDay.getText());
		
		
		List<WebElement> selectMonth = driver.findElements(By.xpath("//select[@title='Month']/option"));
		System.out.println("The default day is " + selectedDay.getText());
		for(WebElement eachMonth : selectMonth) {
			System.out.println("Month : " + eachMonth.getText());
		}

		WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select ddDay = new Select(day);
		ddDay.selectByVisibleText("10");
		WebElement Month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select mMonth = new Select(Month);
		mMonth.selectByVisibleText("Jan");		
		WebElement Year = driver.findElement(By.xpath("//select[@title='Year']"));
		Select yYear = new Select(Year);
		yYear.selectByVisibleText("2022");
		
		//WebElement gender = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		//gender.click();
		
		String Gender = "Female";		
		String genderXpath = "//label[text()='placeholder']";
		String newXpath = genderXpath.replace("placeholder", Gender);
		
		//String newXpath = "//label[text()='" + Gender + "']";
		
		WebElement genderElem = driver.findElement(By.xpath(newXpath));
		genderElem.click();


	}

}
