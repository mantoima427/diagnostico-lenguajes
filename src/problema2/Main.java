package problema2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== PROBLEMA 2: VALIDADOR FEN ===");
        System.out.print("Ingrese cadena FEN: ");
        String fen = scanner.nextLine();
        
        if (FENValidator.validar(fen)) {
            System.out.println("\n[OK] FEN VALIDO");
        } else {
            System.out.println("\n[ERROR] FEN INVALIDO");
        }
        
        scanner.close();
    }
}