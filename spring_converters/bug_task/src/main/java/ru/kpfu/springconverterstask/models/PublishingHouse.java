package ru.kpfu.springconverterstask.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author Alexander Ferenets <istamendil.info>
 */
@Entity
@Table(name = "publishing_house")
public class PublishingHouse implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private int id;
  
  @OneToMany(mappedBy = "publishingHouse", fetch = FetchType.LAZY)
  private List<Book> books = new ArrayList<>();
  
  @NotNull
  @Size(min = 1, max = 255)
  private String name;
  
  @Override
  public String toString(){
    return getName();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
  
}
