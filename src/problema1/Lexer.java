/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Lexer {
    private final String texto;
    private int posicion;
    
    private static final Pattern PATRON_NUMERO = Pattern.compile("^\\d+(\\.\\d+)?");
    private static final Pattern PATRON_OPERADOR = Pattern.compile("^[+\\-*/]");
    private static final Pattern PATRON_PAREN_IZQ = Pattern.compile("^\\(");
    private static final Pattern PATRON_PAREN_DER = Pattern.compile("^\\)");
    private static final Pattern PATRON_OPERANDO = Pattern.compile("^[A-Za-z_][A-Za-z0-9_]*");
    
    public Lexer(String texto) {
        this.texto = texto;
        this.posicion = 0;
    }
    
    public List<Token> tokenizar() {
        List<Token> tokens = new ArrayList<>();
        
        while (posicion < texto.length()) {
            char actual = texto.charAt(posicion);
            
            // Ignorar espacios
            if (Character.isWhitespace(actual)) {
                posicion++;
                continue;
            }
            
            String resto = texto.substring(posicion);
            Token token = null;
            
            Matcher mNumero = PATRON_NUMERO.matcher(resto);
            if (mNumero.find()) {
                String valor = mNumero.group();
                token = new Token(TokenType.NUMERO, valor);
                posicion += valor.length();
            }
            else if (PATRON_OPERADOR.matcher(resto).find()) {
                Matcher m = PATRON_OPERADOR.matcher(resto);
                if (m.find()) {
                    token = new Token(TokenType.OPERADOR, m.group());
                    posicion += m.group().length();
                }
            }
            else if (PATRON_PAREN_IZQ.matcher(resto).find()) {
                token = new Token(TokenType.PAREN_IZQ, "(");
                posicion++;
            }
            else if (PATRON_PAREN_DER.matcher(resto).find()) {
                token = new Token(TokenType.PAREN_DER, ")");
                posicion++;
            }
            else if (PATRON_OPERANDO.matcher(resto).find()) {
                Matcher m = PATRON_OPERANDO.matcher(resto);
                if (m.find()) {
                    token = new Token(TokenType.OPERANDO, m.group());
                    posicion += m.group().length();
                }
            }
            else {
                token = new Token(TokenType.ERROR, String.valueOf(actual));
                posicion++;
            }
            
            tokens.add(token);
        }
        
        return tokens;
    }
    
    public static boolean parentesisBalanceados(List<Token> tokens) {
        int contador = 0;
        for (Token t : tokens) {
            if (t.getTipo() == TokenType.PAREN_IZQ) {
                contador++;
            } else if (t.getTipo() == TokenType.PAREN_DER) {
                contador--;
                if (contador < 0) return false;
            }
        }
        return contador == 0;
    }
}
