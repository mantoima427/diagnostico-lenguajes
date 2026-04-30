/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== PROBLEMA 2: VALIDADOR FEN ===");
        System.out.print("Ingrese cadena FEN: ");
        String fen = scanner.nextLine();
        
        if (FENValidator.validar(fen)) {
            System.out.println("\n✓ FEN VÁLIDO");
        } else {
            System.out.println("\n✗ FEN INVÁLIDO");
        }
        
        scanner.close();
    }
}
