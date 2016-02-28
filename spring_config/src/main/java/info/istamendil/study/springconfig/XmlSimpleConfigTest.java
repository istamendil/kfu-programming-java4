package info.istamendil.study.springconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * Code for studying purposes. Programming course, 4th semestr.
 * Kazan Federal University, ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */

public class XmlSimpleConfigTest {

  public static void main(String[] args) {
    new XmlSimpleConfigTest();
  }
  
  public XmlSimpleConfigTest(){
    System.out.println("XML config context configuration test");
    
    ApplicationContext context = 
             new FileSystemXmlApplicationContext(getClass().getResource("/itisSimpleConfig.xml").toString());
    
    Book obj = (Book) context.getBean("book");
    System.out.println( obj );
    
    obj.setName("Spring in Action");
    obj.setIsbn("9781935182351");
    System.out.println( obj );
  }
}
