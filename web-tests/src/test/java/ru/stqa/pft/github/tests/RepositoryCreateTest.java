package ru.stqa.pft.github.tests;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.github.model.RepositoryData;
import ru.stqa.pft.github.model.Repositoryes;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class RepositoryCreateTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validRepositoryes() throws IOException {
    // List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/repositoryes.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
 /*   String[] split = line.split(";");
      list.add( new Object[] {new RepositoryData().withName(split[0]).withDescription(split[1])});*/
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(RepositoryData.class);
    List<RepositoryData> repositoryes = (List<RepositoryData>) xstream.fromXML(xml);
    return  repositoryes.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();

    // return list.iterator();
  }


  @Test (dataProvider = "validRepositoryes")
  public void testCreateRepository(RepositoryData repository) {
    app.goTo().repositoryPage();
    Repositoryes before = app.repository().all();
    app.repository().create(repository);
    app.goTo().repositoryPage();

 /*   Repositoryes after = app.repository().all();
    assertThat(after.size(), equalTo (before.size() +1));

    //repository.withName(after.stream().mapToInt((g) -> g.getName()).max().getAsInt()); // нахождение max id из всех в списке множества

    assertThat(after, equalTo(before.withAdded(repository)));*/

  }


}

