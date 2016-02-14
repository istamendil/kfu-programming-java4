package info.istamendil.junitexamples;


/**
 * Code for studying purposes. Programming course, 4th semestr.
 * Kazan Federal University, ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class Calculator {
  public enum OPERATOR {PLUS, MINUS, GEOMETRIC_MEAN};
  
  public static double getResult(double firstOperand, double secondOperand, OPERATOR operator){
    double result;
    switch(operator){
      case PLUS:
        result = firstOperand + secondOperand;
      case MINUS:
        result = firstOperand - secondOperand;
        break;
      case GEOMETRIC_MEAN:
        result = Math.sqrt(firstOperand*secondOperand);
        break;
      default:
        throw new IllegalArgumentException("Calculator can't do this operator yet.");
    }
    return result;
  }
  
}
