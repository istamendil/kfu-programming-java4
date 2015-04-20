package ru.kpfu.bookstore.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

@Entity
@Table(name = "book")
public class Book{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private int id;
  
  @Length(max = 65535)
  private String description;
  
  @NotNull
  @Pattern(regexp = "[0-9]{10,14}")
  @Column(unique = true)
  private String isbn;
  
  @NotNull
  @Size(min = 1, max = 255)
  private String name;
  
  @NotNull
  @Range(min = 0L, max = 9999L)
  private Integer pages;
  
  @NotNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "publishing_house", nullable = false)
  private PublishingHouse publishingHouse;
  
  @URL
  private String url;
  
  @NotNull
  @Range(min = 0L, max = 9999L)
  private Integer year;

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

  public PublishingHouse getPublishingHouse() {
    return publishingHouse;
  }

  public void setPublishingHouse(PublishingHouse publishingHouse) {
    this.publishingHouse = publishingHouse;
  }
  
  

}
