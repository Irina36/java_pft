package ru.stqa.pft.github.tests;


import org.testng.annotations.*;
import ru.stqa.pft.github.model.RepositoryDataCreate;


public class RepositoryCreateTest extends TestBase {


  @Test
  public void testCreateRepository() {
    app.getNavigationHelper().gotoNewRepository();
    app.getRepositoryHelper().initRepositoryCreation();
    app.getRepositoryHelper().fillRepositoryForm(new RepositoryDataCreate("My", "111"));
    app.getRepositoryHelper().submitRepositoryCreation();
    app.getNavigationHelper().gotoRepositoryPage();
  }

}

