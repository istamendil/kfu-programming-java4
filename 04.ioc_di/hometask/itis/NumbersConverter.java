package itis;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumbersConverter {
  private JFrame mainFrame;
  private JPanel mainPanel;
  private JTextField resultField;
  protected String[] args;

  public static void main(String[] args) throws Exception {
    NumbersConverter app = new NumbersConverter(args);
  }
  
  public NumbersConverter(String[] args) throws Exception{
    this.args = args;
    createGui();
    convertAndShow();
  }
  
  protected void createGui(){
    mainFrame = new JFrame("Currency Converter");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setMinimumSize(new Dimension(800, 600));
    mainFrame.setVisible(true);
    mainPanel = new JPanel();
    mainFrame.getContentPane().add(mainPanel);
    
    resultField = new JTextField();
    resultField.setColumns(10);
    mainPanel.add(resultField);
  }
  protected void convertAndShow() throws Exception{
    if(args.length<1){
      throw new Exception("First parameter must be a valid amount of rubles.");
    }
    Float amountSource = Float.parseFloat(args[0]);
    Float amountResult = amountSource * 62.3558022f;
    resultField.setText(amountResult.toString());
  }

}
