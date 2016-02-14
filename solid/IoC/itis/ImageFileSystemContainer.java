package itis;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class ImageFileSystemContainer implements ImageContainer {

  protected ArrayList<File> imageList;
  protected int currentIndex;

  public ImageFileSystemContainer(String imagesPath) throws Exception {
    imageList = new ArrayList<>();
    File folder = new File(imagesPath);
    if(!folder.exists()){
      throw new Exception("First parameter must be a correct path to images folder.");
    }
    for (final File fileEntry : folder.listFiles()) {
      if (!fileEntry.isDirectory()) {
        imageList.add(fileEntry.getAbsoluteFile());
      }
    }
    currentIndex = 0;
  }

  @Override
  public BufferedImage getNext(){
    if (imageList.size() < (currentIndex + 1)) {
      currentIndex = 0;
    }
    try {                
       return ImageIO.read( imageList.get(currentIndex++) );
    } catch (IOException ex) {
       new Exception("Can't read image");
    }
    return null;
  }

}
