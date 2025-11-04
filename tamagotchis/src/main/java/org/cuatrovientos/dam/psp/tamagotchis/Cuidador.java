package org.cuatrovientos.dam.psp.tamagotchis;

import java.util.HashMap;
import java.util.Map;

public class Cuidador {
    private Map<String, Tamagotchi> tamagotchis;
    
    public Cuidador() {
        this.tamagotchis = new HashMap<>();
    }
    
    public void agregarTamagotchi(String nombre) {
        Tamagotchi tama = new Tamagotchi(nombre);
        tamagotchis.put(nombre, tama);
    }
    
    public void iniciarTodos() {
        for (Tamagotchi tama : tamagotchis.values()) {
            tama.start();
        }
    }
    
    public void alimentarTamagotchi(String nombre) {
        Tamagotchi tama = tamagotchis.get(nombre);
        if (tama != null && tama.isVivo()) {
            new Thread(() -> tama.alimentar()).start();
        }
    }
    
    public void jugarConTamagotchi(String nombre) {
        Tamagotchi tama = tamagotchis.get(nombre);
        if (tama != null && tama.isVivo()) {
            new Thread(() -> tama.jugar()).start();
        }
    }
    
    public void limpiarTamagotchi(String nombre) {
        Tamagotchi tama = tamagotchis.get(nombre);
        if (tama != null && tama.isVivo()) {
            new Thread(() -> tama.limpiar()).start();
        }
    }
    
    public void matarTamagotchi(String nombre) {
        Tamagotchi tama = tamagotchis.get(nombre);
        if (tama != null && tama.isVivo() && !tama.isOcupado()) {
            tama.morir();
        } else if (tama != null && tama.isOcupado()) {
            System.out.println("No se puede matar a " + nombre + " mientras esta ocupado");
        }
    }
    
    public void mostrarEstados() {
        System.out.println("\n=== ESTADO DE LOS TAMAGOTCHIS ===");
        for (Tamagotchi tama : tamagotchis.values()) {
            System.out.println(tama.getNombre() + 
                             " Vivo: " + (tama.isVivo() ? "Si" : "Nop") +
                             " Suciedad: " + tama.getSuciedad() +
                             " Ocupado: " + (tama.isOcupado() ? "Si" : "No") +
                             " Tiempo restante de vida: " + (tama.getTiempoVidaRestante() / 1000) + "s");
        }
        System.out.println("================================\n");
    }
}
