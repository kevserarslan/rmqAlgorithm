/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algproje1;

/**
 *
 * @author Kevser
 */
public class PrecomputeAll {
     private int[][] table;

    public PrecomputeAll(int[] data) {
        preprocess(data);
    }

    private void preprocess(int[] data) {
        int n = data.length;
        table = new int[n][n];
        for (int i = 0; i < n; i++) {
            table[i][i] = data[i];
            for (int j = i + 1; j < n; j++) {
                table[i][j] = Math.min(table[i][j - 1], data[j]);
            }
        }
    }

    public int query(int left, int right) {
        return table[left][right];
    }
}
