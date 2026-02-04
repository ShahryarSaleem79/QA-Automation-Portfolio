package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        String browser = ConfigReader.get("browser");
        boolean headless = ConfigReader.getBoolean("headless");

        switch(browser.toLowerCase()) {
        case "chrome":
        				WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if (headless) {
				options.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage","--window-size=1920,1080");
			}
			options.addArguments("--remote-allow-origins=*");

			driver.set(new ChromeDriver(options));
			break;
        case "firefox":
        	WebDriverManager.firefoxdriver().setup();
        	FirefoxOptions firefoxOptions = new FirefoxOptions();
        	if (headless) {
				firefoxOptions.addArguments("--headless");
				driver.set(new FirefoxDriver(firefoxOptions));
                break;
        	}

         default:
                throw new RuntimeException("Unsupported browser: " + browser);
			
        }
        
        // Add more browsers later (Firefox, Edge, Remote, etc.)
        getDriver().get(ConfigReader.get("baseUrl"));
        getDriver().manage().window().maximize();
        
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }


}
