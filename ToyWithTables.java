package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.leafground.com/pages/table.html");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		int rowct = rows.size();
		System.out.println("Total row count: " + rowct);

		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table_id']//tr[2]/td"));
		int colct = cols.size();
		System.out.println("Total column count: " + colct);
		
		String interact = driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']/following-sibling::td")).getText();
		System.out.println("Progress value of Learn to interact with Elements: " +interact);
		
		Set<String> progress = new TreeSet<String>();
		for (int i=2; i<=rowct;i++) {
			String pvalue = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			progress.add(pvalue);
			
		}
		
		List<String> newp = new ArrayList<String>(progress);
		String least = newp.get(1);
		System.out.println("The Least Completed Progress Value is :" + least);			  
		driver.findElement(By.xpath("//table[@id='table_id']//tr/td[text()='30%']/following-sibling::td/input[@type='checkbox']")).click();
		
		
	}

}
