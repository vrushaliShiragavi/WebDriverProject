package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertClassExampple {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement okBtn = driver.findElement(By.xpath("//button[@id='alertButton']"));
		okBtn.click();
		Alert obj = driver.switchTo().alert();
		Thread.sleep(2000);
		obj.accept();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		WebElement confirmBtn = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		confirmBtn.click();
		obj = driver.switchTo().alert();
		Thread.sleep(2000);
		obj.dismiss();
		WebElement confirmSpan = driver.findElement(By.xpath("//span[@id='confirmResult']"));
		System.out.println("Selected Btn Msg = " + confirmSpan.getText());
		driver.quit();
	}

}
