package info.istamendil.study.springconfig;

import org.springframework.stereotype.Component;

/**
 * 
 * Code for studying purposes. Programming course, 4th semestr.
 * Kazan Federal University, ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */

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


