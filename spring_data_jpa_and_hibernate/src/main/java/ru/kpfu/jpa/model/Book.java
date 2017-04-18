package ru.kpfu.jpa.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

@Entity
@Table(name = "book")
public class Book implements Serializable { // Why Serializable?

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id = -1;
  
  @Size(min = 1, max = 255)
  @Column
  private String name;
  
  @Length(max = 65535)
  @Column
  private String description;
  
  @Pattern(regexp = "[0-9]{10,14}")
  @Column(unique = true)
  private String isbn;
  
  @NotNull
  @Range(min = 0L, max = 9999L)
  @Column
  private Integer published;
  
  @NotNull
  @Range(min = 0L, max = 9999L)
  @Column
  private Integer pages;
  
  @URL
  @Column
  private String url;

  public Book(){}
  public Book(int id, String name, String description, String isbn, Integer published, Integer pages, String url) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.isbn = isbn;
    this.published = published;
    this.pages = pages;
    this.url = url;
  }
  

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 41 * hash + this.id;
    hash = 41 * hash + Objects.hashCode(this.name);
    hash = 41 * hash + Objects.hashCode(this.description);
    hash = 41 * hash + Objects.hashCode(this.isbn);
    hash = 41 * hash + Objects.hashCode(this.published);
    hash = 41 * hash + Objects.hashCode(this.pages);
    hash = 41 * hash + Objects.hashCode(this.url);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Book other = (Book) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.description, other.description)) {
      return false;
    }
    if (!Objects.equals(this.isbn, other.isbn)) {
      return false;
    }
    if (!Objects.equals(this.published, other.published)) {
      return false;
    }
    if (!Objects.equals(this.pages, other.pages)) {
      return false;
    }
    if (!Objects.equals(this.url, other.url)) {
      return false;
    }
    return true;
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

  public Integer getPublished() {
    return published;
  }

  public void setPublished(Integer published) {
    this.published = published;
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
