package ru.stqa.pft.github.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Repositoryes extends ForwardingSet<RepositoryData> {

  private  Set<RepositoryData> delegate;

  public Repositoryes(Repositoryes repositoryes) {
    this.delegate = new HashSet<RepositoryData>(repositoryes.delegate);
  }

  public Repositoryes() {
    this.delegate = new HashSet<RepositoryData>();
  }

  @Override
  protected Set<RepositoryData> delegate() {
    return delegate;
  }

  public Repositoryes withAdded (RepositoryData repository) {
    Repositoryes repositoryes = new Repositoryes(this);
    repositoryes.add(repository);
    return repositoryes;
  }

  public Repositoryes withoud (RepositoryData repository) {
    Repositoryes repositoryes = new Repositoryes(this);
    repositoryes.add(repository);
    return repositoryes;
  }
}
