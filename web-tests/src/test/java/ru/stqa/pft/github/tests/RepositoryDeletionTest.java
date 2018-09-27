package ru.stqa.pft.github.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.github.model.RepositoryData;
import java.util.Set;


public class RepositoryDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.repository().all().size() == 0) {
      app.repository().create(new RepositoryData().withName("My").withDescription("111"));
    }
  }

  @Test(enabled = false)
  public void testRepositoryDeletion() {
    app.goTo().repositoryPage();
    Set<RepositoryData> before = app.repository().all();
    RepositoryData deletedRepository = before.iterator().next(); // объект, в котором выбирается из последовательного множества первый попавшийся элемент
    app.repository().delete(deletedRepository);
    app.goTo().repositoryPage();
    Set<RepositoryData> after = app.repository().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedRepository);
    Assert.assertEquals(before, after);

  }
}


