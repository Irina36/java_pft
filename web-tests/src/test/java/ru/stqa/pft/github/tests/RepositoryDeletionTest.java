package ru.stqa.pft.github.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.github.model.RepositoryData;
import ru.stqa.pft.github.model.Repositoryes;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


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
    Repositoryes before = app.repository().all();
    RepositoryData deletedRepository = before.iterator().next(); // объект, в котором выбирается из последовательного множества первый попавшийся элемент
    app.repository().delete(deletedRepository);
    app.goTo().repositoryPage();
    Repositoryes after = app.repository().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.withoud(deletedRepository)));

  }
}


