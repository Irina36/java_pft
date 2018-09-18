package ru.stqa.pft.github.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.github.model.RepositoryDataCreate;
import ru.stqa.pft.github.model.RepositoryDataModification;

public class RepositoryHelper extends HelperBase {

  public RepositoryHelper(WebDriver driver) {
    super(driver); // обращение к конструктору базового класса
  }


  public void submitRepositoryCreation() {
    click(By.xpath("//*[@id='new_repository']/div[3]/button"));
  }

  public void fillRepositoryForm(RepositoryDataCreate repositoryDataCreate) {
    type(By.id("repository_name"), repositoryDataCreate.getName());
    type(By.id("repository_description"), repositoryDataCreate.getDescription());

  }

  public void initRepositoryCreation() {
    click(By.xpath("//ul[@id='user-links']/li[2]/details/summary"));
    click(By.linkText("New repository"));
  }

  public void clickDeleteThisRepository() {
    click(By.xpath("//*[@id='options_bucket']/div[8]/ul/li[4]/details/summary"));
  }

  public void fillNameRepositoryDeletion() {
    type(By.xpath("(//input[@name='verify'])[2]"), "My");
  }

  public void clickDeleteRepository() {
    click(By.xpath("//*[@id='options_bucket']/div[8]/ul/li[4]/details/details-dialog/div[3]/form/button"));
  }

  public void selectRepository() {
    click(By.linkText("My"));
  }

  public void initRepositoryModification() {
    click(By.cssSelector("button.float-right:nth-child(1)"));
  }

  public void fillRepositoryModification(RepositoryDataModification repositoryDataModification) {
    type(By.xpath("//*[@id='repo_description']"), repositoryDataModification.getDescription());
    type(By.xpath("//*[@id='repo_homepage']"), repositoryDataModification.getWebsite());
  }

  public void saveRepositoryModification() {
    click(By.xpath("//*[@id='js-repo-pjax-container']/div[2]/div[1]/div[1]/div[1]/form/button[1]"));
  }

  public void createRepository(RepositoryDataCreate repository) {
    initRepositoryCreation();
    fillRepositoryForm(repository);
    submitRepositoryCreation();
  }

  public boolean isThereARepository() {
    return isElementPresent(By.linkText("My"));

  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
