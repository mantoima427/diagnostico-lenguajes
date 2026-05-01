@echo off
echo ========================================
echo   VERIFICANDO INSTALACION DE JAVA
echo   Prueba Diagnostica - Lenguajes
echo ========================================
echo.

java -version >nul 2>&1

if %errorlevel% neq 0 (
    echo [ERROR] Java NO esta instalado en este equipo.
    echo.
    echo Para instalar Java:
    echo 1. Vaya a https://adoptium.net/
    echo 2. Descargue "OpenJDK 17 LTS"
    echo 3. Ejecute el instalador
    echo 4. Reinicie su computadora
    echo.
    pause
    exit /b 1
)

echo [OK] Java esta instalado correctamente.
echo.
java -version
echo.
echo Presione cualquier tecla para salir...
pause > nul