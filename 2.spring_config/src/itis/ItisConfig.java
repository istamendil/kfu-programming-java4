package itis;
import org.springframework.context.annotation.*;

@Configuration
public class ItisConfig {

   @Bean 
   public Book book(){
      return new Book();
   }
}