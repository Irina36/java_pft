package ru.stqa.pft.github.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void gotoNewRepository() {
    click(By.xpath("//ul[@id='user-links']/li[2]/details/summary"));
  }

  public void goToSettings() {
    click(By.xpath("//div[@id='js-repo-pjax-container']/div/nav/a[4]"));
  }

  public void gotoRepositoryPage() {
    click(By.xpath("//img[@alt='@Irina36']"));
    click(By.linkText("Your repositories"));
  }

}
