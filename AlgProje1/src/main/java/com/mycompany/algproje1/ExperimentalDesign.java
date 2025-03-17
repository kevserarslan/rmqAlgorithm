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
public class ExperimentalDesign {
    public void runScalabilityAnalysis() {
        int[] sizes = {50, 100, 1000, 10000};

        for (int n : sizes) {
            int[] data = Utilities.generateRandomArray(n);

            System.out.println("Scalability Analysis for n = " + n);
            measureAlgorithmPerformance(new PrecomputeAll(data), data, n);
            measureAlgorithmPerformance(new SparseTable(data), data, n);
            measureAlgorithmPerformance(new PrecomputeNone(data), data, n);
            measureAlgorithmPerformance(new Blocking(data), data, n);
            // Blocking algoritması eklenebilir.
        }
    }

    public void runDataPatternAnalysis() {
        int n = 1000;
        int[] randomArray = Utilities.generateRandomArray(n);
        int[] sortedArray = randomArray.clone();
        Arrays.sort(sortedArray);
        int[] reversedArray = Utilities.reverseArray(sortedArray);
        System.out.println("--------------------------------------------------------");
       System.out.println("Data Pattern Analysis:");
      System.out.println("n fix 1000 iken random array için PrecomputeAll,SparseTable,PrecomputeNone,Blocking Algoritması ns si. ");
       measureAlgorithmPerformance(new PrecomputeAll(randomArray), randomArray, n);
       measureAlgorithmPerformance(new SparseTable(randomArray), randomArray, n);
       measureAlgorithmPerformance(new PrecomputeNone(randomArray), randomArray, n);
       measureAlgorithmPerformance(new Blocking(randomArray), randomArray, n); 

      System.out.println("-------------------------------------------------------------------- "); 
     System.out.println("n fix 1000 iken Sorted array için PrecomputeAll,SparseTable,PrecomputeNone,Blocking Algoritması ns si. ");
      measureAlgorithmPerformance(new PrecomputeAll(sortedArray), sortedArray, n);
      measureAlgorithmPerformance(new SparseTable(sortedArray), sortedArray, n);
      measureAlgorithmPerformance(new PrecomputeNone(sortedArray), sortedArray, n);
      measureAlgorithmPerformance(new Blocking(sortedArray), sortedArray, n); 

      System.out.println("-------------------------------------------------------------------- "); 
     System.out.println("n fix 1000 iken reversed array için PrecomputeAll,SparseTable,PrecomputeNone,Blocking Algoritması ns si. ");
      
      measureAlgorithmPerformance(new PrecomputeAll(reversedArray), reversedArray, n);
      measureAlgorithmPerformance(new SparseTable(reversedArray), reversedArray, n);
      measureAlgorithmPerformance(new PrecomputeNone(reversedArray), reversedArray, n);
       measureAlgorithmPerformance(new Blocking(reversedArray), reversedArray, n); // 
        
    }

     private void measureAlgorithmPerformance(Object algorithm, int[] data, int n) {
        // Preprocessing time measurement
        long startPreprocessTime = System.nanoTime();
        if (algorithm instanceof PrecomputeAll) {
            new PrecomputeAll(data);
        } else if (algorithm instanceof SparseTable) {
            new SparseTable(data);
        } else if (algorithm instanceof PrecomputeNone) {
            new PrecomputeNone(data);
        } else if (algorithm instanceof Blocking) {
            new Blocking(data);
        }
        long endPreprocessTime = System.nanoTime();
        long preprocessingTime = endPreprocessTime - startPreprocessTime;

        // Query time measurement
        long startQueryTime = System.nanoTime();
        if (algorithm instanceof PrecomputeAll) {
            ((PrecomputeAll) algorithm).query(0, n - 1);
        } else if (algorithm instanceof SparseTable) {
            ((SparseTable) algorithm).query(0, n - 1);
        } else if (algorithm instanceof PrecomputeNone) {
            ((PrecomputeNone) algorithm).query(0, n - 1);
        } else if (algorithm instanceof Blocking) {
            ((Blocking) algorithm).query(0, n - 1);
        }
        long endQueryTime = System.nanoTime();
        long queryTime = endQueryTime - startQueryTime;

        // Printing the results
        System.out.println(algorithm.getClass().getSimpleName() + 
                           " Preprocessing time: " + preprocessingTime + " ns");
        System.out.println(algorithm.getClass().getSimpleName() + 
                           " Query time: " + queryTime + " ns");
    }
}