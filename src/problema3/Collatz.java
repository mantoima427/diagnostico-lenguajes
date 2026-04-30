/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema3;

import java.util.ArrayList;
import java.util.List;

public class Collatz {
    
    public static List<Integer> generarSecuencia(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El número debe ser positivo");
        }
        
        List<Integer> secuencia = new ArrayList<>();
        secuencia.add(n);
        
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            secuencia.add(n);
        }
        
        return secuencia;
    }
    
    public static void verificarIntervalo(int p, int q) {
        int inicio = Math.min(p, q);
        int fin = Math.max(p, q);
        
        System.out.println("\n=== VERIFICANDO INTERVALO [" + inicio + ", " + fin + "] ===\n");
        
        if (fin < 100 * inicio) {
            System.out.println("⚠ ADVERTENCIA: q (" + fin + ") NO es ≥ 100p (" + (100 * inicio) + ")");
            System.out.println("   La demostración NO es concluyente según la regla.\n");
        } else {
            System.out.println("✓ q (" + fin + ") ≥ 100p (" + (100 * inicio) + ") - Demostración válida\n");
        }
        
        for (int i = inicio; i <= fin; i++) {
            List<Integer> secuencia = generarSecuencia(i);
            System.out.print("n=" + i + ": ");
            for (int j = 0; j < secuencia.size(); j++) {
                System.out.print(secuencia.get(j));
                if (j < secuencia.size() - 1) {
                    System.out.print(" → ");
                }
            }
            System.out.println();
        }
        
        System.out.println("\n" + "==================================================");
        System.out.println("Demostrado... La conjetura se cumple en el intervalo verificado.");
        System.out.println("==================================================");
    }
}
