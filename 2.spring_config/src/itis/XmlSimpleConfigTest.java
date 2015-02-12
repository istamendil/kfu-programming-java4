package itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class XmlSimpleConfigTest {

  public static void main(String[] args) {
    System.out.println("XML config context configuration test");
    
    ApplicationContext context = 
             new FileSystemXmlApplicationContext("itisSimpleConfig.xml");
    
    Book obj = (Book) context.getBean("book");
    System.out.println( obj );
    
    obj.setName("Spring in Action");
    obj.setIsbn("9781935182351");
    System.out.println( obj );
  }
}
