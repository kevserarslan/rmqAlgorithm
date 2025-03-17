/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.algproje1;

/**
 *
 * @author Kevser
 */
public class AlgProje1 {

    public static void main(String[] args) {
        
       ExperimentalDesign experiments = new ExperimentalDesign();

        // Bölüm 1: Scalability Analizi
        experiments.runScalabilityAnalysis();

        // Bölüm 2: Farklı Veri Düzenleri Analizi
        experiments.runDataPatternAnalysis();
    }
}
