import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ALexander Ferenets <istamendil.info>
 */
public class XPathTest {
  private static final String XML_URI   = "http://www.w3schools.com/xpath/books.xml";
  private static final String EXPRESSION = "//price";

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args){
    try {
      XPathTest xPathTest = new XPathTest();
    } catch (Exception ex) {
      System.err.println(ex.getMessage());
    }
  }

  public XPathTest() throws Exception{
    
    // Initialize some stuff
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException ex) {
      throw new Exception("Can't crate DocumentBuilder");
    }
    
    // Load XML document from WWW
    Document doc;
    try {
      doc = builder.parse(XML_URI);
    } catch (IOException ex) {
      throw new Exception("Can't get XML by URL " + XML_URI);
    } catch (SAXException ex) {
      throw new Exception("Can't read downloaded XML.");
    }
    
    // Initialize xPath expression
    XPathFactory xPathfactory = XPathFactory.newInstance();
    XPath xpath = xPathfactory.newXPath();
    XPathExpression expr;
    try {
      expr = xpath.compile(EXPRESSION);
    } catch (XPathExpressionException ex) {
      throw new Exception("Can't parse xPath expression " + EXPRESSION);
    }
    
    // Use xPath on our document
    NodeList nodeList;
    try {
      nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
    } catch (XPathExpressionException ex) {
      throw new Exception("Can't evaluate exression");
    }
    
    // Output text of elements
    for( int i = 0 ; i < nodeList.getLength() ; i++ ){
      System.out.println(nodeList.item(0).getTextContent());
    }
  }

}
