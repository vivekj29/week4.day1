package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.leafground.com/pages/sorttable.html");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		int rowct = rows.size();
		System.out.println("Total row count: " + rowct);
		List<String> name = new ArrayList<String>();
		for(int i=1;i<rowct;i++) {
			String nm = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			name.add(nm);
		}
		Collections.sort(name);
		System.out.println("Sorted Names: " +name);
		driver.findElement(By.xpath("//th[text()='Name']")).click();
		List<String> name2 = new ArrayList<String>();
		for(int i=1;i<rowct;i++) {
			String nm2 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			name2.add(nm2);
		}System.out.println("New sorted names: " +name2);
		if(name.equals(name2)) {
			System.out.println("Both lists are equal");
		} 
		else
			System.out.println("Both the list are not equal");

	}

}
