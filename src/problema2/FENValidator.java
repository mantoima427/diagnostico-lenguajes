package problema2;

import java.util.regex.Pattern;

public class FENValidator {
    
    private static final Pattern PATRON_ENROQUE = Pattern.compile("^[KQkq]{1,4}$|^-$");
    private static final Pattern PATRON_AL_PASO = Pattern.compile("^[a-h][36]$|^-$");
    
    public static boolean validar(String fen) {
        if (fen == null || fen.trim().isEmpty()) {
            System.out.println("Error: Cadena vacia o nula");
            return false;
        }
        
        String[] partes = fen.trim().split(" ");
        
        if (partes.length != 6) {
            System.out.println("Error: Se encontraron " + partes.length + " campos, se requieren 6");
            return false;
        }
        
        if (!validarTablero(partes[0])) return false;
        
        if (!partes[1].equals("w") && !partes[1].equals("b")) {
            System.out.println("Error: Turno '" + partes[1] + "' invalido");
            return false;
        }
        
        if (!PATRON_ENROQUE.matcher(partes[2]).matches()) {
            System.out.println("Error: Enroque '" + partes[2] + "' invalido");
            return false;
        }
        
        if (!PATRON_AL_PASO.matcher(partes[3]).matches()) {
            System.out.println("Error: Casilla al paso '" + partes[3] + "' invalida");
            return false;
        }
        
        try {
            int halfmove = Integer.parseInt(partes[4]);
            if (halfmove < 0) {
                System.out.println("Error: Halfmove clock debe ser >= 0");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Halfmove clock debe ser un numero entero");
            return false;
        }
        
        try {
            int fullmove = Integer.parseInt(partes[5]);
            if (fullmove < 1) {
                System.out.println("Error: Fullmove number debe ser >= 1");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Fullmove number debe ser un numero entero");
            return false;
        }
        
        return true;
    }
    
    private static boolean validarTablero(String board) {
        String[] filas = board.split("/");
        
        if (filas.length != 8) {
            System.out.println("Error: " + filas.length + " filas, se requieren 8");
            return false;
        }
        
        String piezasValidas = "pnbrqkPNBRQK";
        
        for (int i = 0; i < filas.length; i++) {
            int total = 0;
            for (char c : filas[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    total += Character.getNumericValue(c);
                } else if (piezasValidas.indexOf(c) != -1) {
                    total++;
                } else {
                    System.out.println("Error: Caracter '" + c + "' invalido en fila " + (i+1));
                    return false;
                }
            }
            if (total != 8) {
                System.out.println("Error: Fila " + (i+1) + " suma " + total + " casillas, deben ser 8");
                return false;
            }
        }
        
        return true;
    }
}