package itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class XmlScanningConfigTest {

  public static void main(String[] args) {
    System.out.println("Scanning context configuration test");
    
    ApplicationContext context
      = new FileSystemXmlApplicationContext("itisScanningConfig.xml");
    
    Book obj = (Book) context.getBean("book");
    System.out.println( obj );
    
    obj.setName("Spring in Action");
    obj.setIsbn("9781935182351");
    System.out.println( obj );
  }

}
