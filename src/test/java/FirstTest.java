import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {


    public WebDriver driver=null;
    @Parameters({"browser","port"})
    @BeforeClass
    public void initialize(String browser, String port) throws MalformedURLException {
        DesiredCapabilities capability= new DesiredCapabilities();
        capability.setBrowserName(browser);
        driver= new RemoteWebDriver(new URL("http://localhost:".concat(port).concat("/wd/hub")), capability);

    }
    @Test
    public void testThis() throws InterruptedException {
        String url="https://www.facebook.com";
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        String browserVersion = caps.getVersion();

        driver.get(url);
        System.out.println(driver.getTitle()+" and "+browserName+" and "+browserVersion);
        driver.manage().window().maximize();
        //do something
        driver.quit();
    }


}
