package internalLinkTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import externalLinkTests.AbstractWebDriverTest;


public class InterestsPageInternalLinksTest extends AbstractWebDriverTest {
	@Test
	public void interestsPageShouldNotContainInternalBrokenLinks() {
		List<WebElement> links = home.clickOnInterestsLink().internalLinks;
		for (WebElement link: links) {
			try {
				URL u = new URL(link.getAttribute("href"));
				String response = isLinkBroken(u);
				//				System.out.println(u.toString()+" "+response);
				Assert.assertThat(response, Matchers.is("OK"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
