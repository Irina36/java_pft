package ru.stqa.pft.github.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.github.model.RepositoryData;
import java.util.Set;


public class RepositoryCreateTest extends TestBase {


  @Test
  public void testCreateRepository() {
    app.goTo().repositoryPage();
    Set<RepositoryData> before = app.repository().all();
    RepositoryData repository = new RepositoryData().withName("kiss").withDescription("111");
    app.repository().create(repository);

    Set<RepositoryData> after = app.repository().all();
    Assert.assertEquals(after.size(), before.size() +1);

    //repository.withName(after.stream().mapToInt((g) -> g.getName()).max().getAsInt()); // нахождение max id из всех в списке множества

    before.add(repository);
    Assert.assertEquals(before, after);

  }


}

