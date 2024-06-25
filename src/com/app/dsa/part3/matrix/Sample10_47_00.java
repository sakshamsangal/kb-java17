package com.app.dsa.part3.matrix;

import java.util.Arrays;

public class Sample10_47_00 {

    public void copyFromMatrix(int[][] src, int[][] des, int col, int rowCount) {

        int y = 0;
        for (int j = 0; j < col; j++) {
            int x = 0;
            for (int i = 0; i < rowCount; i++) {
                des[x++][y] = src[i][j];
            }
            y++;
        }
        System.out.println("des = " + Arrays.deepToString(des));
    }


    public void copyColSameMat(int[][] mat, int y,int colCount, int to1, int rowCount) {

        // get col 1 by 1
        for (int j = y; j <= colCount; j++) {
            for (int i = 0; i < rowCount; i++) {
                mat[i][to1] = mat[i][j];
            }
            to1++;
        }
        System.out.println("ans = " + Arrays.deepToString(mat));
    }


    int[][] rotateMatrix(int k, int mat[][]) {

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 0, 3}, {0, 0, 3}, {7, 8, 9}};
        Sample10_47_00 sample10_47_00 = new Sample10_47_00();
        int[][] ans = new int[3][2];
//        sample10_47_00.copyFromMatrix(mat, ans, 2, 3);
        sample10_47_00.copyFromMatrix(ans, mat, 2, 3);
//        sample10_47_00.copyColSameMat(mat, 1, 3, 3);
    }

}
