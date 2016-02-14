package info.istamendil.junitexamples;

import org.junit.*;

/**
 * Code for studying purposes. Programming course, 4th semestr.
 * Kazan Federal University, ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class CalculatorTest {
  @Test
  public void plusExpression() {
    double result = Calculator.getResult(2, 2, Calculator.OPERATOR.PLUS);
    Assert.assertEquals(4.0, result, 0.0);
  }
  @Test
  public void minusExpression() {
    double result = Calculator.getResult(2, 2, Calculator.OPERATOR.MINUS);
    Assert.assertEquals(0.0, result, 0.0);
  }
  @Test
  public void geometricMeanOneNegativeOperandExpression() {
    double result = Calculator.getResult(2, -8, Calculator.OPERATOR.GEOMETRIC_MEAN);
    Assert.assertTrue(Double.isNaN(result));
  }
  @Test
  public void geometricMeanTwoNegativeOperandsExpression() {
    double result = Calculator.getResult(-2, -8, Calculator.OPERATOR.GEOMETRIC_MEAN);
    Assert.assertTrue(Double.isNaN(result));
  }
}
