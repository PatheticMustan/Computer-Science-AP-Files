import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(256-pixelObj.getRed());
        pixelObj.setGreen(256-pixelObj.getGreen());
        pixelObj.setBlue(256-pixelObj.getBlue());
      }
    }
  }

  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  public void pairArms() {
    int mirrorPoint = 200;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 157; row < mirrorPoint; row++) {
      // loop from 13 to just before the mirror point
      for (int col = 102; col < 294; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[mirrorPoint - row][col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy(Picture fromPic, int startRow, int endRow, int startCol, int endCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < endRow; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < endCol;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public static Picture rotate90CW(Picture picture) {
      int w = picture.getWidth();
      int h = picture.getHeight();
      
      // I hate it here, I spent 5 hours trying to figure out why it was throwing out of bounds
      // turns out it's Picture(height, width)
      // who made this lab, I feel so mad
      // feral
      Picture rotated = new Picture(w, h);
      Pixel[][] p = picture.getPixels2D();
      Pixel[][] rp = rotated.getPixels2D();

      for (int column=0; column<w; column++) {
          for (int row=0; row<h; row++) {
              Pixel from = p[row][column];
              Pixel to = rp[column][h-1-row];
              
              to.setColor(from.getColor());
          }
      }
      
      return rotated;
  }
  
  public void applyKernel(double[][] kernel) {
    // setup vars
    int h = this.getHeight(),
        w = this.getWidth(),
        kernelSize = 3,
        middle = kernelSize / 2;
        
    Pixel[][] picture = this.getPixels2D();
    Pixel[][] ref = new Picture(this).getPixels2D();

    // loop through all pixels
    for (int col=0; col<h; col++) {
      for (int row=0; row<w; row++) {
        int r = 0,
            g = 0,
            b = 0;
        // kernel
        for (int kernelY=0; kernelY<kernelSize; kernelY++) {
          for (int kernelX=0; kernelX<kernelSize; kernelX++) {
            // *will* throw out of bounds errors, but we might as well have fun
            try {
              r += ref[col+kernelY-middle][row+kernelX-middle].getRed() * kernel[kernelY][kernelX];
              g += ref[col+kernelY-middle][row+kernelX-middle].getGreen() * kernel[kernelY][kernelX];
              b += ref[col+kernelY-middle][row+kernelX-middle].getBlue() * kernel[kernelY][kernelX];
            } catch (ArrayIndexOutOfBoundsException e) {
              // ignore lmao
              continue;
            }
          }
        }
        
        int rf = Math.max(0, Math.min(r, 255)), // cap it to 0-255
            gf = Math.max(0, Math.min(g, 255)),
            bf = Math.max(0, Math.min(b, 255));
        picture[col][row].setColor(new Color(rf, gf, bf));
      }
    }
  }
  
  public static void main(String[] args) {
    double[][] sharpen = new double[][] {
      { 0, -1,  0 },
      {-1,  5, -1 },
      { 0, -1,  0 }
    };

    double[][] blur = new double[][] {
      { 0.0625, 0.125,  0.0625 },
      { 0.125,  0.25, 0.125 },
      { 0.0625, 0.125,  0.0625 }
    };

    Picture bf = new Picture("images/butterfly1.jpg");
    bf.explore();
    bf.applyKernel(blur);
    bf.explore();

    Picture af = new Picture("images/beach.jpg");
    af.explore();
    af.applyKernel(sharpen);
    af.explore();
  }
} // this } is the end of class Picture, put all new methods before this
