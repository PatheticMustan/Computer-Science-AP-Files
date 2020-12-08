import java.lang.Math;

public class JaggedLittlePath {
    public static void main(String[] args) {
        int[][] jla = {
            {75},
            {95, 64},
            {17, 47, 82},
            {18, 35, 87, 10},
            {20,  4, 82, 47, 65},
            {19,  1, 23, 75,  3, 34},
            {88,  2, 77, 73,  7, 63, 67},
            {99, 65,  4, 28,  6, 16, 70, 92},
            {41, 41, 26, 56, 83, 40, 80, 70, 33},
            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
            {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
            {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
            {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
            { 4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23}
        };
        
        System.out.println(jlp(jla));
    }
    
    public static int jlp(int[][] jla) {
        // I swear I didn't google this, I thought of it while reading a manga about taming slimes
        // https://mangadex.org/chapter/485570/3
        // it's only possible to move to adjacent rows. Instead of counting from the top, we can count
        // the max possible value. It's because it's in that weird pyramid form that we can do this.
        // count from the bottom!
        // we don't need to keep track of *where* the max path is, just how big it is
        // this method should also work for the more advanced version.
        
        // max starts out as the bottom row.
        int[] max = jla[jla.length-1];
        
        // loop from the second to bottom row all the way to the top
        for (int i=jla.length-2; i>0; i--) {
            // the row above max
            int[] newMax = jla[i];
            
            // loop through the row above max, and add the biggest of max[o] and max[o+1]
            //    3
            //   / \
            //  4   5
            // would add 3 + Math.max(4, 5), so the max of this row would be 8
            for (int o=0; o<newMax.length; o++) {
                newMax[o] += Math.max(max[o], max[o+1]);
            }
            
            // now that we're done going through the row, we need to move on to the next row.
            // set max to the row above
            max = newMax;
        }
        
        // return the last one standing
        return max[0];
        // in this instance, I got 995.
    }
}