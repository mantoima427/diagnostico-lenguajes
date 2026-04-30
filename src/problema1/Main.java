/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== PROBLEMA 1: ANALIZADOR LÉXICO ===");
        System.out.print("Ingrese expresión aritmética: ");
        String expresion = scanner.nextLine();
        
        Lexer lexer = new Lexer(expresion);
        List<Token> tokens = lexer.tokenizar();
        
        System.out.println("\n--- TOKENS ---");
        for (Token t : tokens) {
            System.out.println(t);
        }
        
        if (Lexer.parentesisBalanceados(tokens)) {
            System.out.println("\nPARÉNTESIS BALANCEADOS.");
        } else {
            System.out.println("\nPARÉNTESIS NO BALANCEADOS.");
        }
        
        scanner.close();
    }
}
