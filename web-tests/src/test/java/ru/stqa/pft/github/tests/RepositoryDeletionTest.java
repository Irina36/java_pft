package ru.stqa.pft.github.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.github.model.RepositoryDataCreate;


public class RepositoryDeletionTest extends TestBase {


  @Test
  public void testRepositoryDeletion() {
    app.getNavigationHelper().gotoRepositoryPage();
    if (!app.getRepositoryHelper().isThereARepository()) {
      app.getRepositoryHelper().createRepository(new RepositoryDataCreate("My", "111"));
    }
    app.getNavigationHelper().gotoRepositoryPage();
    app.getRepositoryHelper().selectRepository();
    app.getNavigationHelper().goToSettings();
    app.getRepositoryHelper().clickDeleteThisRepository();
    app.getRepositoryHelper().fillNameRepositoryDeletion();
    app.getRepositoryHelper().clickDeleteRepository();
    app.getNavigationHelper().gotoRepositoryPage();
  }


}
