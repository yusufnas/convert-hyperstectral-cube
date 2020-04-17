package test;

import cezeri.matrix.CMatrix;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YUSUFNAS
 */
public class Exercises {

    public static void main(String[] args) throws InterruptedException {
        double[][][] cube = GeneratePushbroomCube(300, 50, 500);
        CMatrix cm = CMatrix.getInstance();
        for (int i = 0; i < 50; i++) {
            double[][] d = getSpectralBandImage(cube, i);
            cm.setArray(d).imshowRefresh(i + ". spectral band  " + (404 + i * (320.0 / 50)) + " peak intensity");
            Thread.sleep(50);

//            try {
//                Thread.sleep(500);
//            } catch (Exception ex) {
//                Logger.getLogger(Odev.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

    }

    private static double[][][] GeneratePushbroomCube(int width, int band, int height) {
        double[][][] ret = new double[width][band][height];
        double[] arr1 = new double[band];
        double[][] arr2 = new double[band][height];

        for (int j = 0; j < band; j++) {
            arr1[j] = 0xff * j / band;
            for (int i = 0; i < width; i++) {
                for (int k = 0; k < height; k++) {
                    arr2[j][k] = arr1[j];
                    ret[i][j][k] = arr2[j][k];
                }
            }
        }

        return ret;
    }

    private static double[][] getSpectralBandImage(double[][][] cube, int band) {
        int width = cube.length;
        int height = cube[band][band].length;
        double[][] ret = new double[width][height];

        for (int i = 0; i < width; i++) {
            System.arraycopy(cube[i][band], 0, ret[i], 0, height);

        }
        return ret;
    }
}
