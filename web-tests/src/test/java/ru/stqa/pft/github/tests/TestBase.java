package ru.stqa.pft.github.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.pft.github.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeClass
  public void setUp() {
    app.init();
  }

  @AfterClass
  public void tearDown() {
    app.stop();
  }

}
