@echo off
echo ========================================
echo   EJECUTANDO PRUEBA DIAGNOSTICA
echo ========================================
echo.

cd /d C:\Users\Mariangel\Documents\NetBeansProjects\diagnostico-lenguajes

echo.
echo ========== PROBLEMA 1 ==========
echo Analizador Lexico
echo Ejemplo: 12+ 3 * (4)
echo.
java -cp src problema1.Main

echo.
echo ========== PROBLEMA 2 ==========
echo Validador FEN
echo Ejemplo: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1
echo.
java -cp src problema2.Main

echo.
echo ========== PROBLEMA 3 ==========
echo Conjetura de Collatz
echo Ejemplo: p=6, q=8
echo.
java -cp src problema3.Main

echo.
echo ========================================
echo   EJECUCION COMPLETA
echo ========================================
pause