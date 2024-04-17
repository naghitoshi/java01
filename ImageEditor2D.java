
package java01;

import javax.imageio.ImageIO;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.util.Arrays;

public class ImageEditor2D{
  static BufferedImage readImage(String filename){
    BufferedImage img = null;
    try{
      img = ImageIO.read(new File(filename));
      System.out.println("Load: " + filename);
    }catch(Exception e){
      e.printStackTrace();
    }
    return img;
  }
  
  static boolean writeImage(BufferedImage img, String filename){
    boolean result = false;
    try{
      result = ImageIO.write(img, "jpeg", new File(filename));
      System.out.println("Save: " + filename);
    } catch (Exception e) {
      e.printStackTrace();
      result = false;
    }
    return result;
  }

  static boolean writeImage(BufferedImage img){
    return writeImage(img, "sample.jpg");
  }

  static BufferedImage resizeImage(BufferedImage orgimg, int width, int height){
    var orgWidth = orgimg.getWidth();
    var orgHeight = orgimg.getHeight();

    BufferedImage resizedImage = new BufferedImage(width, height, orgimg.getType());
    var scaled = orgimg.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
    resizedImage.getGraphics().drawImage(scaled, 0, 0, width, height, null);

    System.out.print("Resize: (" + orgWidth + ", " + orgHeight + ") -> ");
    System.out.println("(" + width + ", " + height + ")");

    return resizedImage;
  }

  static BufferedImage scaleImage(BufferedImage orgimg, double ratio){
    var orgWidth = orgimg.getWidth();
    var orgHeight = orgimg.getHeight();

    int width = (int)(orgWidth * ratio);
    int height = (int)(orgHeight * ratio);
    BufferedImage resizedImage = new BufferedImage(width, height, orgimg.getType());
    var scaled = orgimg.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
    resizedImage.getGraphics().drawImage(scaled, 0, 0, width, height, null);

    System.out.print("scale: (" + orgWidth + ", " + orgHeight + ") -> ");
    System.out.println("(" + width + ", " + height + ")");

    return resizedImage;
  }

  static BufferedImage scaleImage(BufferedImage orgimg, int ratio){
    return scaleImage(orgimg, (double)ratio);
  }

  static BufferedImage scaleImage(BufferedImage orgimg, int length, String option){
    var orgWidth = orgimg.getWidth();
    var orgHeight = orgimg.getHeight();

    String[] basedWidth = {"width","w", "x"};
    String[] basedHeight = {"height","h", "y"};
    int width = 0;
    int height = 0;
    
    if(isStringInArray(option, basedWidth)){
      width = length;
      height = (int)((double)orgHeight * ((double)length / (double)orgWidth));
    }else if(isStringInArray(option, basedHeight)){
      width = (int)((double)orgWidth * ((double)length / (double)orgHeight));
      height = length;
    }else{
      System.err.println("Error: Argument \"option\" not supported. ");
      System.err.println("Supported arguments(option) = " + Arrays.toString(basedWidth) 
                          + " or " + Arrays.toString(basedHeight));
      System.exit(1);
    }

    BufferedImage resizedImage = new BufferedImage(width, height, orgimg.getType());
    var scaled = orgimg.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
    resizedImage.getGraphics().drawImage(scaled, 0, 0, width, height, null);

    System.out.print("Scale: (" + orgWidth + ", " + orgHeight + ") -> ");
    System.out.println("(" + width + ", " + height + ")");

    return resizedImage;
  } 

  private static boolean isStringInArray(String target, String[] array) {
    for (String str : array) {
        if (str.equals(target)) {
            return true;
        }
    }
    return false;
  }

  public static void main(String[] args){
    BufferedImage Image;
    BufferedImage tmpImage;
    Image = readImage(args[0]);
    tmpImage = resizeImage(Image, 100, 100);
    writeImage(tmpImage, "sample1.jpg");
    tmpImage = resizeImage(Image, 200, 200);
    writeImage(tmpImage, "sample2.jpg");
    tmpImage = scaleImage(Image, 2.0);
    writeImage(tmpImage, "sample3.jpg");
    tmpImage = scaleImage(Image, 1000, "x");
    writeImage(tmpImage, "sample4.jpg");

  }
  
}
