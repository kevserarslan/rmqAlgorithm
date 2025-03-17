/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algproje1;

import java.util.Random;

/**
 *
 * @author Kevser
 */
public class Utilities {
    private static final int SEED = 42; // Rastgele dizinin aynı kalmasını sağlayacak tohum

    public static int[] generateRandomArray(int size) {
        //Random random = new Random();
        //return random.ints(size, 1, 10001).toArray();
        Random random = new Random(SEED); // Aynı seed değeri ile Random nesnesi oluşturuluyor
        return random.ints(size, 1, 10001).toArray(); 
    }

    public static int[] reverseArray(int[] array) {
        int[] reversed = array.clone();
        for (int i = 0; i < array.length / 2; i++) {
            int temp = reversed[i];
            reversed[i] = reversed[array.length - 1 - i];
            reversed[array.length - 1 - i] = temp;
        }
        return reversed;
    }
}
