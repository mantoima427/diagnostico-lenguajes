/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

public enum TokenType {
    NUMERO,      // Para números enteros o reales
    OPERADOR,    // Para + - * /
    PAREN_IZQ,   // Paréntesis que abre (
    PAREN_DER,   // Paréntesis que cierra )
    OPERANDO,    // Variables como valor, CONT, x
    ERROR;       // Caracteres no reconocidos
    
    @Override
    public String toString() {
        return this.name();
    }
}