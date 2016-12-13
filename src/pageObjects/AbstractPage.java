package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractPage {
	protected WebDriver driver;
	protected static final String landing = "http://rheneas.eng.buffalo.edu/~rsubrama";
	protected static final String research = "http://rheneas.eng.buffalo.edu/~rsubrama/research.html";
	protected static final String cv = "http://rheneas.eng.buffalo.edu/~rsubrama/cv.html";
	protected static final String interests = "http://rheneas.eng.buffalo.edu/~rsubrama/interests.html";
	protected static final String photoGallery = "http://rheneas.eng.buffalo.edu/~rsubrama/photoGallery.html";
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage navigateToHomePage() {
		driver.navigate().to(landing);
		return new HomePage(driver);
	}

	public ResearchPage navigateToResearchPage() {
		driver.navigate().to(research);
		return new ResearchPage(driver);
	}

	public CVPage navigateToCVPage() {
		driver.navigate().to(cv);
		return new CVPage(driver);
	}

	public InterestsPage navigateToInterestsPage() {
		driver.navigate().to(interests);
		return new InterestsPage(driver);
	}

	public PhotoGalleryPage navigateToPhotoGalleryPage() {
		driver.navigate().to(photoGallery);
		return new PhotoGalleryPage(driver);
	}

	public HomePage clickOnHomeLink() {
		driver.findElement(By.cssSelector("a[href='index.html']")).click();
		return new HomePage(driver);
	}

	public ResearchPage clickOnResearchLink() {
		driver.findElement(By.cssSelector("a[href='research.html']")).click();
		return new ResearchPage(driver);
	}

	public CVPage clickOnCVLink() {
		driver.findElement(By.cssSelector("a[href='cv.html']")).click();
		return new CVPage(driver);
	}

	public InterestsPage clickOnInterestsLink() {
		driver.findElement(By.cssSelector("a[href='interests.html']")).click();
		return new InterestsPage(driver);
	}

	public PhotoGalleryPage clickOnPhotoGalleryLink() {
		driver.findElement(By.cssSelector("a[href='photoGallery.html']")).click();
		return new PhotoGalleryPage(driver);
	}
	public List<WebElement> getAllLinks() {
		return driver.findElements(By.tagName("a"));
	}
}
