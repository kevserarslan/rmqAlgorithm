/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algproje1;

/**
 *
 * @author Kevser
 */
public class PrecomputeNone {
    private int[] data;

    public PrecomputeNone(int[] data) {
        this.data = data;
    }

    public int query(int left, int right) {
        int min = data[left];
        for (int i = left + 1; i <= right; i++) {
            min = Math.min(min, data[i]);
        }
        return min;
    }
}
