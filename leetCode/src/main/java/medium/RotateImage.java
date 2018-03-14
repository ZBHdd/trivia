package medium;

/**
 * 给你一个代表图像的n × n二维矩阵。
 * 将图像旋转90度（顺时针）。
 * 注意：您必须在原地旋转图像，这意味着您必须直接修改输入的2D矩阵。不要分配另一个2D矩阵并进行旋转。
 *
 * @author hdd
 */
public class RotateImage {
    /**
     * [i][j]
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * 先对称
     * [j][i]
     * [ 5, 2,13,15],
     * [ 1, 4, 3,14],
     * [ 9, 8, 6,12],
     * [11,10, 7,16]
     * 再进行 行交换
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     *
     * @param matrix 二维矩阵
     * @return 旋转后的二维矩阵
     */
    public int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int c;
        int d;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                c = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = c;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                d = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = d;
            }
        }
        return matrix;
    }

    /**
     * [i][j]
     * 00  01  02  03
     * 10  11  12  13
     * 20  21  22  23
     * 30  31  32  33
     * <p>
     * 目标
     * 30  20  10  00
     * 31  21  11  01
     * 32  22  12  02
     * 33  23  13  03
     *
     * 03->33->30->00  i=0,j=0
     * 13->32->20->01  i=0,j=1
     * ...
     */
    public int[][] rotate2(int[][] matrix) {
        int n = matrix.length;
        int a;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                a = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = a;
            }
        }
        return matrix;
    }
}
