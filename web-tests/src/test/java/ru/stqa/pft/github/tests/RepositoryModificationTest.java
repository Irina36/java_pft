package ru.stqa.pft.github.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.github.model.RepositoryData;
import java.util.Set;

public class RepositoryModificationTest extends TestBase {

  @AfterMethod
  public void ensurePreconditions () {
    if (app.repository().all().size() == 0) {
      app.repository().create(new RepositoryData().withName("Your").withDescription("111"));
    }
  }

  @Test
  public void testRepositoryModification () {

    app.goTo().repositoryPage();
    Set<RepositoryData> before = app.repository().all();
    RepositoryData modifiedRepository = before.iterator().next(); // объект, в котором выбирается из последовательного множества первый попавшийся элемент
    RepositoryData repository = new RepositoryData()
            .withName(modifiedRepository.getName()).withDescription("My test repository").withWebsite("https://github.com/Irina36/java_pft");
    app.repository().modify(repository);
    app.goTo().repositoryPage();
    Set<RepositoryData> after = app.repository().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedRepository);
    before.add(repository);
    Assert.assertEquals(before,after);

  }


}

