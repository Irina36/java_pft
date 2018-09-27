package ru.stqa.pft.github.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }



  public void repositoryPage() {
    click(By.xpath("//img[@alt='@Irina36']"));
    click(By.linkText("Your repositories"));
  }

}
