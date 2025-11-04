package org.cuatrovientos.dam.psp.tamagotchis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cuidador {
    private List<Tamagotchi> tamagotchis;
    private Scanner scanner;
    
    public Cuidador() {
        this.tamagotchis = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void agregarTamagotchi(Tamagotchi tamagotchi) {
        tamagotchis.add(tamagotchi);
    }
    
    public void ponerPilasYLanzar() {
        System.out.println("Cuidador: Poniendo pilas a los Tamagotchis...");
        for (Tamagotchi tamagotchi : tamagotchis) {
            tamagotchi.start();
            System.out.println(tamagotchi.getIdTamagotchi() + " ha sido lanzado al mundo!");
        }
        System.out.println("Todos los Tamagotchis estan vivos ahora!");
    }
    
    public void mostrarEstados() {
        System.out.println("\n--- ESTADO DE LOS TAMAGOTCHIS ---");
        for (Tamagotchi tamagotchi : tamagotchis) {
            System.out.println(tamagotchi.getIdTamagotchi() + 
                " - Estado: " + tamagotchi.getEstado() + 
                " - Suciedad: " + tamagotchi.getSuciedad() + 
                " - Vivo: " + (tamagotchi.isVivo() ? "SI" : "NO"));
        }
        System.out.println("--------------------------------\n");
    }
    
    public void alimentarTamagotchi(String id) {
        for (Tamagotchi tamagotchi : tamagotchis) {
            if (tamagotchi.getIdTamagotchi().equals(id)) {
                if (tamagotchi.comer()) {
                    System.out.println("Cuidador: Alimentando a " + id);
                } else {
                    System.out.println(id + " no puede comer ahora. Estado: " + tamagotchi.getEstado());
                }
                return;
            }
        }
        System.out.println("Tamagotchi " + id + " no encontrado");
    }
    
    public void jugarConTamagotchi(String id) {
        for (Tamagotchi tamagotchi : tamagotchis) {
            if (tamagotchi.getIdTamagotchi().equals(id)) {
                if (tamagotchi.jugar()) {
                    System.out.println("Cuidador: Jugando con " + id);
                } else {
                    System.out.println(id + " no puede jugar ahora. Estado: " + tamagotchi.getEstado());
                }
                return;
            }
        }
        System.out.println("Tamagotchi " + id + " no encontrado");
    }
    
    public void limpiarTamagotchi(String id) {
        for (Tamagotchi tamagotchi : tamagotchis) {
            if (tamagotchi.getIdTamagotchi().equals(id)) {
                if (tamagotchi.limpiar()) {
                    System.out.println("Cuidador: Limpiando a " + id);
                } else {
                    System.out.println(id + " no puede limpiarse ahora. Estado: " + tamagotchi.getEstado());
                }
                return;
            }
        }
        System.out.println("Tamagotchi " + id + " no encontrado");
    }
    
    public boolean responderPregunta(String idTamagotchi, int respuestaCorrecta) {
        System.out.print("Cuidador responde a " + idTamagotchi + ": ");
        try {
            int respuesta = scanner.nextInt();
            return respuesta == respuestaCorrecta;
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar buffer
            return false;
        }
    }
    
    public void destruirTamagotchi(String id) {
        for (Tamagotchi tamagotchi : tamagotchis) {
            if (tamagotchi.getIdTamagotchi().equals(id)) {
                if (tamagotchi.puedeSerDestruido()) {
                    System.out.println("Cuidador: Destruyendo a " + id);
                    tamagotchi.morir();
                } else {
                    System.out.println("No se puede destruir a " + id + ", no esta ocioso. Estado: " + tamagotchi.getEstado());
                }
                return;
            }
        }
        System.out.println("Tamagotchi " + id + " no encontrado");
    }
    
    public void mostrarTamagotchisDisponibles() {
        System.out.println("\nTamagotchis disponibles:");
        for (Tamagotchi tamagotchi : tamagotchis) {
            if (tamagotchi.isVivo()) {
                System.out.println("- " + tamagotchi.getIdTamagotchi() + " (Estado: " + tamagotchi.getEstado() + ")");
            }
        }
    }
    
    public void mostrarMenu() {
        System.out.println("\n=== MENU DEL CUIDADOR ===");
        System.out.println("1. Mostrar estados de todos");
        System.out.println("2. Alimentar un Tamagotchi");
        System.out.println("3. Jugar con un Tamagotchi");
        System.out.println("4. Limpiar un Tamagotchi");
        System.out.println("5. Destruir Tamagotchi");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opcion: ");
    }
}