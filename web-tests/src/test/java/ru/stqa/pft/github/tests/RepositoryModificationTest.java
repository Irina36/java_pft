package ru.stqa.pft.github.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.github.model.RepositoryDataCreate;
import ru.stqa.pft.github.model.RepositoryDataModification;

public class RepositoryModificationTest extends TestBase{

  @Test
  public void testRepositoryModification () {
    app.getNavigationHelper().gotoRepositoryPage();
    if (!app.getRepositoryHelper().isThereARepository()) {
      app.getRepositoryHelper().createRepository(new RepositoryDataCreate("My", "111"));
    }
    app.getNavigationHelper().gotoRepositoryPage();
    app.getRepositoryHelper().selectRepository();
    app.getRepositoryHelper().initRepositoryModification();
    app.getRepositoryHelper().fillRepositoryModification(new RepositoryDataModification("My test repository", "https://github.com/Irina36/java_pft"));
    app.getRepositoryHelper().saveRepositoryModification();
    app.getNavigationHelper().gotoRepositoryPage();


  }
}
