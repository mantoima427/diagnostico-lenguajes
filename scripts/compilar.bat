@echo off
echo ========================================
echo   COMPILANDO PROYECTO JAVA
echo   Prueba Diagnostica - Lenguajes
echo ========================================
echo.

cd /d C:\Users\Mariangel\Documents\NetBeansProjects\diagnostico-lenguajes

echo [1/3] Compilando Problema 1...
"C:\Program Files\Java\jdk1.8.0_111\bin\javac.exe" src/problema1/*.java
if %errorlevel% neq 0 (
    echo ERROR en Problema 1
    pause
    exit /b 1
)
echo OK
echo.

echo [2/3] Compilando Problema 2...
"C:\Program Files\Java\jdk1.8.0_111\bin\javac.exe" src/problema2/*.java
if %errorlevel% neq 0 (
    echo ERROR en Problema 2
    pause
    exit /b 1
)
echo OK
echo.

echo [3/3] Compilando Problema 3...
"C:\Program Files\Java\jdk1.8.0_111\bin\javac.exe" src/problema3/*.java
if %errorlevel% neq 0 (
    echo ERROR en Problema 3
    pause
    exit /b 1
)
echo OK
echo.

echo ========================================
echo   COMPILACION EXITOSA
echo ========================================
echo.
echo Para ejecutar los programas:
echo   java -cp src problema1.Main
echo   java -cp src problema2.Main
echo   java -cp src problema3.Main
echo.
pause