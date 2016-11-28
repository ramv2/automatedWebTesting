package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CVPage extends AbstractPage {
	public List<WebElement> internalLinks = new ArrayList<>(),externalLinks = new ArrayList<>();
	public CVPage (WebDriver driver) {
		super(driver);
		List<WebElement> allLinks = getAllLinks();
		for (WebElement w: allLinks) {
			String url = w.getAttribute("href");
			if (url == null) continue;
			if (url.contains("~rsubrama")) internalLinks.add(w);
			else if (!url.contains("profile-badge") && !url.contains("rsubramanian2")) externalLinks.add(w);
		}
	}
}
