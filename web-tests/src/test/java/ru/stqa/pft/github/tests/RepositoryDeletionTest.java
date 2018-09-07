package ru.stqa.pft.github.tests;


import org.testng.annotations.Test;


public class RepositoryDeletionTest extends TestBase {


  @Test
  public void testRepositoryDeletion() {
    app.getNavigationHelper().gotoRepositoryPage();
    app.getRepositoryHelper().selectRepository();
    app.getNavigationHelper().goToSettings();
    app.getRepositoryHelper().clickDeleteRepository();
    app.getRepositoryHelper().fillNameRepositoryDeletion();
    app.getRepositoryHelper().clickDeleteThisRepository();
    app.getNavigationHelper().gotoRepositoryPage();
  }


}
