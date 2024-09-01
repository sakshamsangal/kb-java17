package com.app.dsa.part3.recursion;

import java.util.ArrayList;


public class NQueen {

    public void nQueenRec(int col, boolean[][] mat) {
        if (col == mat.length) {
            // path found
            addPath(mat);
            return;
        }
        for (int i = 0; i < mat.length; i++) {
            if (isLineSafe(i, col, mat)
                    && isUpSafe(i, col, mat)
                    && isDownSafe(i, col, mat)
            ) {
                mat[i][col] = true;
                nQueenRec(col + 1, mat);
                mat[i][col] = false;
            }
        }
    }


    private boolean isUpSafe(int row, int col, boolean[][] mat) {
        row--;
        col--;
        while (col != -1 && row != -1) {
            if (mat[row][col]) {
                return false;
            }
            row--;
            col--;
        }
        return true;
    }


    private boolean isDownSafe(int row, int col, boolean[][] mat) {
        row++;
        col--;
        while (col != -1 && row != mat.length) {
            if (mat[row][col]) {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    private boolean isLineSafe(int row, int col, boolean[][] mat) {
        col--;
        while (col != -1) {
            if (mat[row][col]) {
                return false;
            }
            col--;
        }
        return true;
    }

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    private void addPath(boolean[][] mat) {
        ArrayList<Integer> path = new ArrayList<>();
        for (int j = 0; j < mat[0].length; j++) {
            for (boolean[] rows : mat) {
                if (rows[j]) {
                    path.add(j+1);
                    break;
                }
            }
        }
        ans.add(path);
    }

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ans.clear();
        nQueenRec(0, new boolean[n][n]);
        return ans;
    }
}
