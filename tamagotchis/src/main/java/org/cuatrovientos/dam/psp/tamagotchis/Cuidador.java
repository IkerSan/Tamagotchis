package org.cuatrovientos.dam.psp.tamagotchis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cuidador {
    private final List<Tamagotchi> tamagotchis = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    
    public void agregar(Tamagotchi t) { tamagotchis.add(t); }
    
    public void ponerPilas() {
        System.out.println("=== Poniendo pilas a los Tamagotchis ===");
        for (Tamagotchi t : tamagotchis) {
            t.start();
            System.out.println("✓ " + t.getNombre() + " activado");
        }
        System.out.println();
    }
    
    public void mostrarEstados() {
        System.out.println("\n=== ESTADO DE LOS TAMAGOTCHIS ===");
        for (int i = 0; i < tamagotchis.size(); i++) {
            Tamagotchi t = tamagotchis.get(i);
            System.out.printf("%d. %s - %s - Suciedad:%d - %s\n", 
                i + 1, t.getNombre(), t.getEstado(), t.getSuciedad(), 
                t.isVivo() ? "VIVO" : "MUERTO");
        }
        System.out.println();
    }
    
    private Tamagotchi get(int index) {
        if (index < 1 || index > tamagotchis.size()) {
            System.out.println("Error: Número inválido (1-" + tamagotchis.size() + ")");
            return null;
        }
        return tamagotchis.get(index - 1);
    }
    
    public void alimentar(int num) {
        Tamagotchi t = get(num);
        if (t != null) {
            if (!t.comer()) System.out.println(t.getNombre() + " no puede comer ahora (" + t.getEstado() + ")");
        }
    }
    
    public void jugar(int num) {
        Tamagotchi t = get(num);
        if (t != null) {
            if (!t.jugar()) System.out.println(t.getNombre() + " no puede jugar ahora (" + t.getEstado() + ")");
        }
    }
    
    public void limpiar(int num) {
        Tamagotchi t = get(num);
        if (t != null) {
            if (!t.limpiar()) System.out.println(t.getNombre() + " no puede limpiarse ahora (" + t.getEstado() + ")");
        }
    }
    
    public void destruir(int num) {
        Tamagotchi t = get(num);
        if (t != null) {
            if (t.estaOcioso()) {
                System.out.println("Destruyendo a " + t.getNombre() + "...");
                t.morir();
            } else {
                System.out.println("No se puede destruir: " + t.getNombre() + " está " + t.getEstado());
            }
        }
    }
    
    public boolean responderPregunta(String nombre, int correcta) {
        System.out.print("Respuesta para " + nombre + ": ");
        try {
            return scanner.hasNextInt() && scanner.nextInt() == correcta;
        } catch (Exception e) {
            scanner.nextLine();
            return false;
        }
    }
    
    public void mostrarMenu() {
        System.out.println("\n=== MENÚ ===");
        System.out.println("1. Ver estados");
        System.out.println("2. Alimentar");
        System.out.println("3. Jugar");
        System.out.println("4. Limpiar");
        System.out.println("5. Destruir");
        System.out.println("6. Salir");
        System.out.print("Opción: ");
    }
    
    public Scanner getScanner() { return scanner; }
}