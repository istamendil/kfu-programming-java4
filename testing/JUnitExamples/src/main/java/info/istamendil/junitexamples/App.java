package info.istamendil.junitexamples;

/**
 * Manual head-on testing
 * 
 * Code for studying purposes. Programming course, 4th semestr.
 * Kazan Federal University, ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class App {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    // Plus operator
    System.out.println("Calculator Plus test");
    if(Calculator.getResult(2, 2, Calculator.OPERATOR.PLUS) == 4.0){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
    
    // Minus operator
    System.out.println("Calculator Minus test");
    if(Calculator.getResult(2, 2, Calculator.OPERATOR.MINUS) == 0.0){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
    
    // Geometric Mean operator
    System.out.println("Geometric Mean test with two positive operands");
    if(Calculator.getResult(2, 8, Calculator.OPERATOR.GEOMETRIC_MEAN) == 4.0){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
    System.out.println("Geometric Mean test with one negative operand and one positive operand");
    if(Double.isNaN(Calculator.getResult(2, -8, Calculator.OPERATOR.GEOMETRIC_MEAN))){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
    System.out.println("Geometric Mean test with two negative operands");
    if(Double.isNaN(Calculator.getResult(-2, -8, Calculator.OPERATOR.GEOMETRIC_MEAN))){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
  }

}
