package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);

		List<WebElement> tableRows = driver.findElements(By.cssSelector("table#customers>tbody>tr"));
		System.out.println("Total Number Of Rows  " + tableRows.size());

		List<WebElement> Columns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println("Total no of columns are " + Columns.size());

		WebElement data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]/td[1]"));
		System.out.println("The data is " + data.getText());

		/*for (int i = 0; i < tableRows.size(); i++) {
			List<WebElement> columnData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td"));
			for (WebElement Cdata : columnData) {
				System.out.println(Cdata.getText());
			}
		}*/

		for (int i = 2; i <= tableRows.size(); i++) {
			List<WebElement> ColumnsData = driver.findElements(By.xpath("//table[@id='customers']//tr[" + i + "]/td"));
			System.out.println(ColumnsData.get(0).getText() + " " + ColumnsData.get(1).getText() + " "
					+ ColumnsData.get(2).getText());

		}

	}

}
