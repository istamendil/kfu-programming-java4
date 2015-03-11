package ru.kpfu.bookstore;

import javax.validation.constraints.*;

public class Book {
  @NotNull
  @Size(min=5, max=128)
  private String name;
  @Size(max=1024)
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
