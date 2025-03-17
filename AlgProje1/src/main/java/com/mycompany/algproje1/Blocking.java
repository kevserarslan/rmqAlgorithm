/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algproje1;

import java.util.Arrays;

/**
 *
 * @author Kevser
 */
public class Blocking {
     private int[] data;
    private int[] blockMins;
    private int blockSize;

    public Blocking(int[] data) {
        this.data = data;
        preprocess();
    }

    private void preprocess() {
        int n = data.length;

        // Blok boyutunu karekök alarak belirliyorum
        blockSize = (int) Math.ceil(Math.sqrt(n));
        int numBlocks = (int) Math.ceil((double) n / blockSize);

        // Blok minimumlarını saklayacak array oluştuyorum
        blockMins = new int[numBlocks];
        Arrays.fill(blockMins, Integer.MAX_VALUE);

        // Her blok için minimum değer hesaplanıyor bu kıısmda
        for (int i = 0; i < n; i++) {
            int blockIndex = i / blockSize;
            blockMins[blockIndex] = Math.min(blockMins[blockIndex], data[i]);
        }
    }

    public int query(int left, int right) {
        int min = Integer.MAX_VALUE;

        // Sol ve sağ sınırları belirledim
        int startBlock = left / blockSize;
        int endBlock = right / blockSize;

        if (startBlock == endBlock) {
            // Sol ve sağ aynı bloktaysa doğrudan işleme kısmı
            for (int i = left; i <= right; i++) {
                min = Math.min(min, data[i]);
            }
        } else {
            // Sol bloğun kalan kısmını işleme kısmı
            for (int i = left; i < (startBlock + 1) * blockSize; i++) {
                min = Math.min(min, data[i]);
            }

            // Ortadaki tam blokları işleme kısmı
            for (int i = startBlock + 1; i < endBlock; i++) {
                min = Math.min(min, blockMins[i]);
            }

            // Sağ bloğun başlangıcını işleleme kısmı
            for (int i = endBlock * blockSize; i <= right; i++) {
                min = Math.min(min, data[i]);
            }
        }

        return min;
    }
}
