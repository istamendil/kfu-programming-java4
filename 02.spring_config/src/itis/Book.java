package itis;

import org.springframework.stereotype.Component;

@Component
public class Book {
  private String name = "The Book";
  private String isbn = "0000000000000";

  public void setName(String name) {
    this.name = name;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
    
  public String getName(){
    return name;
  }

  public String getIsbn() {
    return isbn;
  }
  
  public String toString(){
    return getName()+" "+getIsbn();
  }
  
}


