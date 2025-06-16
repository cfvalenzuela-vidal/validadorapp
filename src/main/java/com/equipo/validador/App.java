package com.equipo.validador;

public class App {
    public static void main(String[] args) {
        String usuario = "admin";
        String contrasena = "123456"; // Hardcoded credentials
        
        if (usuario.equals("admin")) {
            System.out.println("¡Bienvenido administrador!");
        }
    }
}