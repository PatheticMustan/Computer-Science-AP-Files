import java.awt.*;

public class kernelSanders {
  public static Picture applyKernel(Picture pic, double[][] kernel) {
    // setup vars
    int h = pic.getHeight(),
        w = pic.getWidth(),
        kernelSize = 3,
        middle = kernelSize / 2;
        
    Pixel[][] picture = pic.getPixels2D();
    Pixel[][] ref = new Picture(pic).getPixels2D();

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
    return pic;
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
    applyKernel(bf, blur).explore();

    Picture af = new Picture("images/beach.jpg");
    af.explore();
    applyKernel(af, sharpen).explore();
  }
}
