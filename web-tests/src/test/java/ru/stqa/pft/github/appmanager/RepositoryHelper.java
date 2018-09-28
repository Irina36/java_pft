package ru.stqa.pft.github.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.github.model.RepositoryData;
import ru.stqa.pft.github.model.Repositoryes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositoryHelper extends HelperBase {

  public RepositoryHelper(WebDriver driver) {
    super(driver); // обращение к конструктору базового класса
  }


  public void submitRepositoryCreation() {
    click(By.xpath("//*[@id='new_repository']/div[3]/button"));
  }

  public void fillRepositoryForm(RepositoryData repositoryDataCreate) {
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

  private void selectRepository(String name) {
    driver.findElement(By.xpath("//*[@id='user-repositories-list']//a[contains(text(),'" + name + "')]")).click();
  }

  public void initRepositoryModifyDescription() {
    click(By.xpath("//*[@id='repo-meta-edit']/summary/div[1]/div/span[2]"));
  }

  public void fillRepositoryModifyDescription(RepositoryData repositoryDataModification) {
    type(By.xpath("//*[@id='repo_description']"), repositoryDataModification.getDescription());
    type(By.xpath("//*[@id='repo_homepage']"), repositoryDataModification.getWebsite());
  }

  public void fillRepositoryModifyName(RepositoryData repositoryDataModification) {
    type(By.xpath("//*[@id='rename-field']"), repositoryDataModification.getDescription());
  }

  public void saveRepositoryModifyDescription() {
    click(By.xpath("//*[@id=\"repo-meta-edit\"]/form/div[3]/button[1]"));
  }

  private void saveRepositoryModifyName() {
    click(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/div/form[1]/button"));
  }

  public void goToSettings() {
    click(By.xpath("//div[@id='js-repo-pjax-container']/div/nav/a[4]"));
  }

  public void create(RepositoryData repository) {
    initRepositoryCreation();
    fillRepositoryForm(repository);
    submitRepositoryCreation();
    repositoryCache = null;
  }

  public void modify(RepositoryData repository) {
    selectRepository(repository.getName());
    initRepositoryModifyDescription();
    fillRepositoryModifyDescription(repository);
    saveRepositoryModifyDescription();
    goToSettings();
    fillRepositoryModifyName(repository);
    saveRepositoryModifyName();
    repositoryCache = null;
  }

  public void delete(RepositoryData repository) {
    selectRepository(repository.getName());
    goToSettings();
    clickDeleteThisRepository();
    fillNameRepositoryDeletion();
    clickDeleteRepository();
    repositoryCache = null;
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

  public int getRepositoryCount() {
    return driver.findElements(By.xpath("//*[@id='user-repositories-list']//a[@itemprop='name codeRepository']")).size();
  }

  private Repositoryes repositoryCache = null;

  public Repositoryes all() {
    if (repositoryCache != null) {
      return new Repositoryes(repositoryCache);
    }

    repositoryCache = new Repositoryes();
    List<WebElement> elements = driver.findElements(By.xpath("//*[@id='user-repositories-list']//a"));

    for (WebElement element : elements) {
      String name = element.getText();
      /*int id = Integer.parseInt(element.findElement(By.xpath("//*[@id='user-repositories-list']//a[@itemprop='name codeRepository']")).getAttribute("offsetTop"));*/
      repositoryCache.add(new RepositoryData().withName(name));
    }
    return new Repositoryes(repositoryCache);

  }

}
