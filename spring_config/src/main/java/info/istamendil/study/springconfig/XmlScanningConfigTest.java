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

public class XmlScanningConfigTest {

  public static void main(String[] args) {
    new XmlScanningConfigTest();
  }
  
  public XmlScanningConfigTest(){
    System.out.println("Scanning context configuration test");
    
    ApplicationContext context
      = new FileSystemXmlApplicationContext(getClass().getResource("/itisScanningConfig.xml").toString());
    
    Book obj = (Book) context.getBean("book");
    System.out.println( obj );
    
    obj.setName("Spring in Action");
    obj.setIsbn("9781935182351");
    System.out.println( obj );
  }

}
