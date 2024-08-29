package ATV02;

import java.util.Random;

public class Matriz {
    public static void main(String[] args) {
        // Define uma matriz 3x3
        int[][] matriz = new int[3][3];
        Random random = new Random();

        // Preenche a matriz com valores aleatórios entre 1 e 100
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100) + 1; // Números entre 1 e 100
            }
        }

        // Exibe a matriz
        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Calcula e exibe a soma dos elementos de cada linha
        System.out.println("Soma dos elementos de cada linha:");
        for (int i = 0; i < matriz.length; i++) {
            int soma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[i][j];
            }
            System.out.println("Soma da linha " + (i + 1) + ": " + soma);
        }
    }
}

