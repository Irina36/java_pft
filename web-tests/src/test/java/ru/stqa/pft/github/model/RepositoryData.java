package ru.stqa.pft.github.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Objects;

  @XStreamAlias("repository")
public class RepositoryData {

  private  String name;
  private  String description;
  private  String website;

  public RepositoryData withName(String name) {
    this.name = name;
    return this;
  }

  public RepositoryData withDescription(String description) {

    this.description = description;
    return this;
  }

  public RepositoryData withWebsite(String website) {
    this.website = website;
    return this;
  }

  public String getName() {
    return name;

  }

  public String getDescription() {
    return description;
  }

  public String getWebsite() {
    return website;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RepositoryData that = (RepositoryData) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "RepositoryDataCreate{" +

            "name='" + name + '\'' +
            '}';
  }

}
