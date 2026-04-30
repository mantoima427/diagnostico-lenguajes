/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

public class Token {
    private final TokenType tipo;
    private final String valor;
    
    public Token(TokenType tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public TokenType getTipo() { return tipo; }
    public String getValor() { return valor; }
    
    @Override
    public String toString() {
        return tipo + " " + valor;
    }
}
