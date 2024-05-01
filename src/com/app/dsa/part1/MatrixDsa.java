package com.app.dsa.part1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixDsa {


    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        printRow(matrix, 0, 0, n - 1);
        printCol(matrix, n - 1, 1, m - 1);

        printRow(matrix, 2, 0, n - 2);
        return null;
    }

    private void printCol(int[][] matrix, int colNum, int rowStart, int rowEnd) {
        for (int i = rowStart; i <= rowEnd; i++) {
            System.out.println("matrix = " + matrix[i][colNum]);
        }
        System.out.println();
    }


    private void printRow(int[][] matrix, int rowNum, int colStart, int colEnd) {
        for (int i = colStart; i <= colEnd; i++) {
            System.out.println("matrix = " + matrix[rowNum][i]);
        }
        System.out.println();
    }

    public void transpose(int[][] matrix) {

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    public void rotate90(int[][] mat, int n) {
        transpose(mat);
        int end = n - 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[end][j];
                mat[end][j] = temp;
            }
            end--;
        }
    }

    public int[] antiDiagonalPattern(int[][] matrix) {
        int[] antDia = new int[matrix.length * matrix.length];
        int start = 0;
        for (int j = 0; j < matrix.length; j++) {
            int col = j;
            for (int i = 0; i <= j; i++) {
                antDia[start++] = matrix[i][col];
                col--;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            int row = i;
            for (int j = matrix.length - 1; j >= 0 && row < matrix.length; j--) {
                antDia[start++] = matrix[row][j];
                row++;
            }
        }

        return antDia;
    }


    public ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Integer> setDecimal = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    num = num + (1 << j);
                }
            }
            if (setDecimal.contains(num)) {
                ans.add(i);
            } else {
                setDecimal.add(num);
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        MatrixDsa matrixDsa = new MatrixDsa();
        int[][] mat = new int[][]{{0, 0, 3}, {0, 0, 3}, {7, 8, 9}};
        ArrayList<Integer> integers = matrixDsa.repeatedRows(mat, 3, 3);
        System.out.println("integers = " + integers);
    }


}
