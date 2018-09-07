package ru.stqa.pft.github.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase {


  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void login(String username, String password) {
    click(By.linkText("Sign in"));
    type(By.id("login_field"), username );
    type(By.id("password"), password);
    click(By.name("commit"));
  }
}
