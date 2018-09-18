package ru.stqa.pft.github.tests;


import org.testng.annotations.*;
import ru.stqa.pft.github.model.RepositoryDataCreate;


public class RepositoryCreateTest extends TestBase {


  @Test
  public void testCreateRepository() {
    app.getRepositoryHelper().createRepository(new RepositoryDataCreate("My", "111"));
    app.getNavigationHelper().gotoRepositoryPage();
  }

}

