package ru.stqa.pft.github.model;

public class RepositoryDataCreate {
  private final String name;
  private final String description;

  public RepositoryDataCreate(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
