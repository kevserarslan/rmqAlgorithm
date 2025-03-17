/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algproje1;

/**
 *
 * @author Kevser
 */
public class SparseTable {
     private int[][] table;
    private int[] log;

    public SparseTable(int[] data) {
        preprocess(data);
    }

    private void preprocess(int[] data) {
        int n = data.length;
        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int k = log[n] + 1;
        table = new int[k][n];
        System.arraycopy(data, 0, table[0], 0, n);

        for (int j = 1; j < k; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                table[j][i] = Math.min(table[j - 1][i], table[j - 1][i + (1 << (j - 1))]);
            }
        }
    }

    public int query(int left, int right) {
        int j = log[right - left + 1];
        return Math.min(table[j][left], table[j][right - (1 << j) + 1]);
    }
}
