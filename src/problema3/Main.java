/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== PROBLEMA 3: CONJETURA DE COLLATZ ===");
        
        try {
            System.out.print("Ingrese p (entero positivo): ");
            int p = scanner.nextInt();
            System.out.print("Ingrese q (entero positivo): ");
            int q = scanner.nextInt();
            
            if (p <= 0 || q <= 0) {
                System.out.println("Error: Ambos números deben ser positivos.");
                return;
            }
            
            Collatz.verificarIntervalo(p, q);
            
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar números enteros válidos.");
        }
        
        scanner.close();
    }
}
