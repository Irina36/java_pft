package ru.stqa.pft.github.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class ApplicationManager {

  WebDriver driver;

  private NavigationHelper navigationHelper;
  private RepositoryHelper repositoryHelper;
  private SessionHelper sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    System.setProperty("webdriver.chrome.driver", "/home/irina_okhotina/Документы/Projects/pageobjectseleniumtest/drivers/chromedriver");
    System.setProperty("webdriver.gecko.driver", "/home/irina_okhotina/Документы/Projects/pageobjectseleniumtest/drivers/geckodriver");


    if (browser.equals(BrowserType.CHROME) ) {
      driver = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX) ) {
      driver = new FirefoxDriver();
    } else  if (browser.equals(BrowserType.IE) ) {
      driver = new InternetExplorerDriver();
    }
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://github.com/GITHUB");
    repositoryHelper = new RepositoryHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("ohotina.i@gmail.com", "gospoga36");
  }


  public void stop() {
    driver.quit();
  }

  public RepositoryHelper repository() {
    return repositoryHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }
}
