package org.cuatrovientos.dam.psp.tamagotchis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cuidador cuidador = new Cuidador();

        // Crear Tamagotchis
        cuidador.agregar(new Tamagotchi("Tama1", cuidador));
        cuidador.agregar(new Tamagotchi("Tama2", cuidador));
        cuidador.agregar(new Tamagotchi("Tama3", cuidador));

        cuidador.ponerPilas();

        Scanner sc = cuidador.getScanner();
        boolean ejecutando = true;

        while (ejecutando) {
            cuidador.mostrarMenu();
            
            if (!sc.hasNextInt()) {
                System.out.println("Error: Introduce un número");
                sc.nextLine();
                continue;
            }
            
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1: 
                    cuidador.mostrarEstados(); 
                    break;
                    
                case 2: case 3: case 4: case 5:
                    cuidador.mostrarEstados();
                    System.out.print("Número de Tamagotchi: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Error: Introduce un número");
                        sc.nextLine();
                        break;
                    }
                    int num = sc.nextInt();
                    
                    if (opcion == 2) cuidador.alimentar(num);
                    else if (opcion == 3) cuidador.jugar(num);
                    else if (opcion == 4) cuidador.limpiar(num);
                    else cuidador.destruir(num);
                    break;
                    
                case 6:
                    ejecutando = false;
                    System.out.println("\n¡Adiós!");
                    break;
                    
                default:
                    System.out.println("Opción inválida (1-6)");
            }
        }

        sc.close();
        System.exit(0);
    }
}