/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscadorDeCombinaciones {
    
    // Función que encuentra combinaciones que suman el número elegido
    public static List<List<Integer>> encontrarCombinaciones(int numeroElegido) {
        // Usamos todos los números del 1 hasta el número elegido
        int[] numeros = new int[numeroElegido];
        for (int i = 0; i < numeroElegido; i++) {
            numeros[i] = i + 1;
        }
        
        List<List<Integer>> resultado = new ArrayList<>();
        buscarCombinaciones(numeros, numeroElegido, 0, new ArrayList<>(), resultado);
        return resultado;
    }
    
    // Función que busca las combinaciones
    private static void buscarCombinaciones(int[] numeros, int objetivo, int inicio, 
                                          List<Integer> actual, List<List<Integer>> resultado) {
        if (objetivo == 0) {
            resultado.add(new ArrayList<>(actual));
            return;
        }
        if (objetivo < 0 || inicio >= numeros.length) {
            return;
        }
        
        // Usar el número actual
        actual.add(numeros[inicio]);
        buscarCombinaciones(numeros, objetivo - numeros[inicio], inicio, actual, resultado);
        
        // No usar el número actual
        actual.remove(actual.size() - 1);
        buscarCombinaciones(numeros, objetivo, inicio + 1, actual, resultado);
    }
    
    // Programa principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Preguntar al usuario
        System.out.print("¿Qué número quieres que sumen las combinaciones? ");
        int numeroElegido = scanner.nextInt();
        
        // Encontrar combinaciones
        List<List<Integer>> combinaciones = encontrarCombinaciones(numeroElegido);
        
        // Mostrar resultados
        System.out.println("\nCombinaciones que suman " + numeroElegido + ":");
        for (List<Integer> combo : combinaciones) {
            System.out.println(combo);
        }
        
        System.out.println("\nTotal: " + combinaciones.size() + " combinaciones");
        
        scanner.close();
    }
}