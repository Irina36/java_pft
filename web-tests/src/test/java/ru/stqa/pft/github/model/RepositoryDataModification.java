package ru.stqa.pft.github.model;

public class RepositoryDataModification {
  private final String description;
  private final String website;

  public RepositoryDataModification(String description, String website) {
    this.description = description;
    this.website = website;
  }

  public String getDescription() {
    return description;
  }

  public String getWebsite() {
    return website;
  }
}
