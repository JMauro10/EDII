package ATV02;

import java.util.Random;

public class Vetor {
    public static void main(String[] args) {
        // Define o vetor diretamente com 10 posições
        int[] vetor = new int[10];
        Random random = new Random();

        // Preenche o vetor com valores aleatórios entre 1 e 100
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100) + 1; // Números entre 1 e 100
        }

        // Inicializa o maior e o menor com o primeiro elemento do vetor
        int maior = vetor[0];
        int menor = vetor[0];

        // Encontra o maior e o menor número no vetor
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }

        // Mostra os resultados
        System.out.print("ATV02.Vetor: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();

        System.out.println("Maior número: " + maior);
        System.out.println("Menor número: " + menor);
    }
}