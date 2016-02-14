import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageViewer {
  private JFrame mainFrame;
  private JPanel mainPanel;
  private HashMap<String, String> config;
  protected String[] args;
  
  protected ImageContainer imageContainer;
  protected BufferedImage currentImage;

  public static void main(String[] args) throws Exception {
    ImageViewer app = new ImageViewer(args);
    app.setImageContainer(
      new ImageFileSystemContainer( app.getConfigValue("images-path") )
    );
  }
  
  public ImageViewer(String[] args) throws Exception{
    this.args = args;
    initConfig();
    createGui();
  }
  
  public String getConfigValue(String name){
    return config.get(name);
  }

  public void setImageContainer(ImageContainer imageContainer) {
    this.imageContainer = imageContainer;
  }
  
  protected void initConfig() throws Exception{
    config = new HashMap<>();
    if(args.length<1){
      throw new Exception("First parameter must be a correct path to images folder.");
    }
    config.put("images-path", args[0]);
  }
  protected void createGui(){
    mainFrame = new JFrame("ImageViewer");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setMinimumSize(new Dimension(800, 600));
    mainFrame.setVisible(true);
    
    // Exit by ESC
    mainFrame.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent ke) {  // handler
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
          System.exit(0);
        }
      }
    });
    
    mainPanel = new imagePanel();
    mainFrame.getContentPane().add(mainPanel);
    
    mainPanel.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        currentImage = imageContainer.getNext();
        mainPanel.repaint();
      }

      @Override
      public void mousePressed(MouseEvent e) {}

      @Override
      public void mouseReleased(MouseEvent e) {}

      @Override
      public void mouseEntered(MouseEvent e) {}

      @Override
      public void mouseExited(MouseEvent e) {}      
      
    });
    
  }
  
  class imagePanel extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      if(currentImage != null){
        g.drawImage(currentImage, 0, 0, null);
      }
    }
  }

}
