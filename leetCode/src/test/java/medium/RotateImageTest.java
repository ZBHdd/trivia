package medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RotateImageTest {
    private RotateImage rotateImage = new RotateImage();

    @Test
    void rotate() {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println(Arrays.deepToString(rotateImage.rotate(matrix)));
    }

    @Test
    void rotate2() {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println(Arrays.deepToString(rotateImage.rotate2(matrix)));
    }
}