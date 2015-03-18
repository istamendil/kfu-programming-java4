package ru.kpfu.bookstore.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ALexander Ferenets <istamendil.info>
 */
@Service
public class Grabber {

  public ArrayList<String> grab(String Url, String xpath) throws MalformedURLException, IOException, XPatherException, IllegalArgumentException {
    ArrayList<String> results = new ArrayList<>();
    
    URL site = new URL(Url);
    BufferedReader in = new BufferedReader(
      new InputStreamReader(site.openStream()));

    String inputLine;
    StringBuilder outputLine = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
      outputLine.append(inputLine);
    }
    in.close();
    
    String page = outputLine.toString();
    HtmlCleaner cleaner = new HtmlCleaner();
    TagNode html = cleaner.clean(page);
    Object[] data = html.evaluateXPath(xpath);
    if(data.length != 0){
      if(data[0].getClass().equals(StringBuffer.class) || data[0].getClass().equals(String.class)){
        for (Object item : data) {
          results.add(item.toString());
        }
      }
      else if(data[0].getClass().equals(TagNode.class)){
        TagNode tempTagNode;
        for (Object item : data) {
          tempTagNode = (TagNode) item;
          results.add(tempTagNode.getText().toString());
        }
      }
      else{
        throw new IllegalArgumentException("Can't process given xpath (result type is " + data[0].getClass() + ")");
      }
    }
    return results;
  }
}
