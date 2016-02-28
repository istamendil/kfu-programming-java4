package info.istamendil.study.springconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * Code for studying purposes. Programming course, 4th semestr.
 * Kazan Federal University, ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */

public class JavaSimpleConfigTest {

  public static void main(String[] args) {
    System.out.println("Java config context configuration test");
    
    ApplicationContext context
      = new AnnotationConfigApplicationContext(SimpleConfig.class);
    
    Book obj = (Book) context.getBean("book");
    System.out.println( obj );
    
    obj.setName("Spring in Action");
    obj.setIsbn("9781935182351");
    System.out.println( obj );
  }
}
