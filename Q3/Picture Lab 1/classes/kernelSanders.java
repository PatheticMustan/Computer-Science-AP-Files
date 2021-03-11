import java.awt.*;

// please grade mercifully, I even made a pun! That's gotta deserve a bonus or something!
// all hail Colonel Sanders
// https://store.steampowered.com/app/1121910/I_Love_You_Colonel_Sanders_A_Finger_Lickin_Good_Dating_Simulator/
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
        // sum of red/green/blue
        int r = 0,
            g = 0,
            b = 0;
        // loop thru kernel
        for (int kernelY=0; kernelY<kernelSize; kernelY++) {
          for (int kernelX=0; kernelX<kernelSize; kernelX++) {
            // *will* throw out of bounds errors, but we might as well have fun
            try {
              // I wish we didn't have to handle red green blue seperately
              // multiply the surrounding pixels by the multiplier in the kernel
              r += ref[col+kernelY-middle][row+kernelX-middle].getRed() * kernel[kernelY][kernelX];
              g += ref[col+kernelY-middle][row+kernelX-middle].getGreen() * kernel[kernelY][kernelX];
              b += ref[col+kernelY-middle][row+kernelX-middle].getBlue() * kernel[kernelY][kernelX];
            } catch (ArrayIndexOutOfBoundsException e) {
              // if there's an out of bounds error, we can just ignore it lmao
              continue;
            }
          }
        }
        
        // there are some cases where RGB is outside of 0-255, which is a no-no.
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

    Picture bf = new Picture("butterfly1.jpg");
    bf.explore();
    applyKernel(bf, blur).explore();

    Picture af = new Picture("beach.jpg");
    af.explore();
    applyKernel(af, sharpen).explore();
  }
}
