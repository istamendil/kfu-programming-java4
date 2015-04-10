package ru.kpfu.bookstore.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

@Entity
@Table(name = "book")
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private int id;
  
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  
  @Length(max = 65535)
  @Column(name = "description")
  private String description;
  
  @Pattern(regexp = "[0-9]{10,14}")
  @Column(name = "isbn", unique = true)
  private String isbn;
  
  @NotNull
  @Range(min = 0L, max = 9999L)
  @Column(name = "year")
  private Integer year;
  
  @NotNull
  @Range(min = 0L, max = 9999L)
  @Column(name = "pages")
  private Integer pages;
  
  @URL
  @Column(name = "url")
  private String url;

  public Book(){}
  public Book(int id, String name) {
    this.id = id;
    this.name = name;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
  
  

}
