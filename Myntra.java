package week4.day1assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.myntra.com/");
		Actions builder = new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
		builder.moveToElement(men).perform();
		WebElement jacket = driver.findElement(By.xpath("//a[@href='/men-jackets']"));
		builder.click(jacket).perform();
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println(count);
		String count1 = count.replaceAll("[^\\d.]", "");
		System.out.println(count1);
		
		String catct1 = driver.findElement(By.xpath("//span[text()='Categories']/following::span")).getText();
		System.out.println(catct1);
		String cat1 = catct1.replaceAll("[^\\d.]", "");
		System.out.println(cat1);
		
		String catct2 = driver.findElement(By.xpath("(//span[text()='Categories']/following::span)[2]")).getText();
		System.out.println(catct2);
		String cat2 = catct2.replaceAll("[^\\d.]", "");
		System.out.println(cat2);
		
	}

}
