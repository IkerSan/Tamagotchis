package org.cuatrovientos.dam.psp.tamagotchis;

import java.util.Random;
import java.util.Scanner;

public class Tamagotchi extends Thread {
    private String nombre;
    private boolean vivo;
    private int suciedad;
    private long tiempoCreacion;
    private boolean ocupado;
    private Random random;
    
    public Tamagotchi(String nombre) {
        this.nombre = nombre;
        this.vivo = true;
        this.suciedad = 0;
        this.tiempoCreacion = System.currentTimeMillis();
        this.ocupado = false;
        this.random = new Random();
    }
    
    @Override
    public void run() {
        System.out.println(nombre + " ha nacido!");
        
        while (vivo) {
            // Verificar tiempo de vida (5 minutos = 300000 ms)
            if (System.currentTimeMillis() - tiempoCreacion > 300000) {
                System.out.println(nombre + ": Soy demasiado viejo. Me muero");
                morir();
                break;
            }
            
            // Incrementar suciedad cada 20 segundos
            try {
                Thread.sleep(20000);
                if (!ocupado) {
                    incrementarSuciedad();
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    
    public synchronized void alimentar() {
        if (!vivo || ocupado) return;
        
        ocupado = true;
        System.out.println(nombre + ": Empezando a comer!");
        
        // Tiempo de comida aleatorio entre 2-6 segundos
        int tiempoComida = random.nextInt(2, 7);
        
        //El hilo 'duerme' durante esos segundos
        try {
            Thread.sleep(tiempoComida * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println(nombre + ": ¡He terminado de comer! (" + tiempoComida + "s)");
        ocupado = false;
    }
    
    public synchronized void jugar() {
        if (!vivo || ocupado) return;
        
        ocupado = true;
        boolean respuestaCorrecta = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!respuestaCorrecta && vivo) {
            // Generar suma simple
            int num1 = random.nextInt(5) + 1; // 1-5
            int num2 = random.nextInt(5) + 1; // 1-5
            int resultado = num1 + num2;
            
            System.out.println("🎮 " + nombre + ": ¿Cuánto es " + num1 + " + " + num2 + "?");
            
            try {
                int respuesta = scanner.nextInt();
                
                if (respuesta == resultado) {
                    System.out.println("✅ " + nombre + ": ¡Correcto! ¡Qué divertido!");
                    respuestaCorrecta = true;
                } else {
                    System.out.println("❌ " + nombre + ": Incorrecto. ¡Inténtalo de nuevo!");
                }
            } catch (Exception e) {
                System.out.println("❌ " + nombre + ": Eso no es un número válido");
                scanner.next(); // Limpiar buffer
            }
        }
        
        ocupado = false;
    }
    
    public synchronized void limpiar() {
        if (!vivo || ocupado) return;
        
        ocupado = true;
        System.out.println("🚿 " + nombre + ": ¡Empezando el baño!");
        
        try {
            Thread.sleep(5000); // 5 segundos para limpiarse
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        suciedad = 0;
        System.out.println("✨ " + nombre + ": ¡Estoy limpio y brillante!");
        ocupado = false;
    }
    
    private void incrementarSuciedad() {
        suciedad++;
        System.out.println("💩 " + nombre + ": Suciedad +1 = " + suciedad);
        
        if (suciedad == 5) {
            System.out.println("⚠️ " + nombre + ": ¡Estoy empezando a estar muy sucio!");
        } else if (suciedad >= 10) {
            System.out.println("💀 " + nombre + ": ¡Demasiada suciedad! He muerto...");
            morir();
        }
    }
    
    public synchronized void morir() {
        vivo = false;
        System.out.println("💀 " + nombre + " ha muerto.");
        interrupt();
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public boolean isVivo() { return vivo; }
    public int getSuciedad() { return suciedad; }
    public boolean isOcupado() { return ocupado; }
    public long getTiempoVidaRestante() {
        return 300000 - (System.currentTimeMillis() - tiempoCreacion);
    }
}
